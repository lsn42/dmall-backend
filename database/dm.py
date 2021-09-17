import os
path = {
    "source": "D:\\project\\dmall-backend\\database\\tmalldemodb.sql",
}


def format_values(values):
    r = ""
    for v in values:
        r += ("'"+str(v)+"', ") if (v != "null" and v != "NULL") else "null, "
    return "("+r[:-2]+")"


def cut_values(line):
    l = line[line.find("(")+1:line.rfind(")")].split(", ")
    for i in range(len(l)):
        l[i] = l[i][1:-1]if (l[i] != "null" and l[i] != "NULL")else "null"
    return l


def remap(list, map):
    n = [None]*len(map)
    for i in map:
        n[i] = list[map[i]]
    return n


def remove_unlinked(content, parent, children, index):
    i = 0
    while i < len(content[children]):
        exist = False
        for cc in content[parent]:
            if content[children][i][index] == cc[0]:
                exist = True
                break
        if not exist:
            content[children].pop(i)
        else:
            i += 1


fs = os.path.split(path["source"])
# fd = fs[1].rfind(".sql")
# path["dest"] = os.path.join(fs[0], fs[1][:fd]+"-ddl"+fs[1][fd:])
path["dest"] = os.path.join(fs[0], "dmall-dml.sql")


IS = "INSERT INTO `%s` VALUES"  # insert statement
NISO = ["admin", "role", "admin_role", "permission", "role_permission",
        "first_level_category", "second_level_category", "third_level_category",
        "product", "product_image", "property", "property_value",
        "address", "user", "user_address",
        "product_order", "product_order_item", "review",
        "advertisement_category", "advertisement"]  # insert statement order

wc = {}  # write content
sc = []  # sub category
for _ in NISO:
    wc[_] = []
with open(path["source"], encoding="utf-8")as f:
    l = f.readline()
    while l:
        # admin module
        if l.startswith(IS % "admin"):
            wc["admin"].append(cut_values(l))
        elif l.startswith(IS % "role"):
            wc["role"].append(cut_values(l))
        elif l.startswith(IS % "admin_role"):
            wc["admin_role"].append(remap(cut_values(l), {0: 1, 1: 2}))
        elif l.startswith(IS % "permisson"):
            # the original table wrongly spelt
            wc["permission"].append(cut_values(l))
        elif l.startswith(IS % "role_permission"):
            wc["role_permission"].append(remap(cut_values(l), {0: 1, 1: 2}))
        # category module
        elif l.startswith(IS % "category"):
            wc["first_level_category"].append(cut_values(l))
        elif l.startswith(IS % "product"):
            cv = cut_values(l)  # cut value
            cvts = cv[2].split(" ")  # cut value title split
            if len(cvts) == 1:
                sc.append(
                    {"id": str(len(sc)+1), "name": cvts[0], "level": 2, "parent": str(cv[7])})
                sc.append(
                    {"id": str(len(sc)+1), "name": cvts[0], "level": 3, "parent": str(len(sc))})
            elif len(cvts) == 2:
                sc.append(
                    {"id": str(len(sc)+1), "name": cvts[0], "level": 2, "parent": str(cv[7])})
                sc.append(
                    {"id": str(len(sc)+1), "name": cvts[1], "level": 3, "parent": str(len(sc))})
            cv[7] = str(len(sc))
            wc["product"].append(cv)
        elif l.startswith(IS % "productimage"):
            wc["product_image"].append(cut_values(l))
        elif (l.startswith(IS % "property")):
            wc["property"].append(cut_values(l))
        elif (l.startswith(IS % "propertyvalue")):
            wc["property_value"].append(
                remap(cut_values(l), {0: 3, 1: 2, 2: 1}))
        # user module
        elif l.startswith(IS % "address"):
            wc["address"].append(cut_values(l))
        elif l.startswith(IS % "user"):
            wc["user"].append(cut_values(l))
        elif l.startswith(IS % "productorder"):
            wc["product_order"].append(cut_values(l))
        # order module
        elif l.startswith(IS % "productorderitem"):
            wc["product_order_item"].append(cut_values(l))
        elif l.startswith(IS % "review"):
            wc["review"].append(cut_values(l))
        # advertisement moduel
        elif l.startswith(IS % "advertisement"):
            wc["advertisement"].append(cut_values(l))
        elif l.startswith(IS % "advertisement_category"):
            wc["advertisement_category"].append(cut_values(l))
        l = f.readline()

# rearrange categories
for c in sc:
    if c["level"] == 2:
        wc["second_level_category"].append(
            [str(len(wc["second_level_category"])+1), c["parent"], c["name"], "NULL"])
    elif c["level"] == 3:
        mp = 0
        for cc in sc:
            if cc["level"] == 2 and c["parent"] == cc["id"]:
                mp = cc["name"]
        for cc in wc["second_level_category"]:
            if cc[2] == mp:
                mp = cc[0]
        wc["third_level_category"].append(
            [str(len(wc["third_level_category"])+1), mp, c["name"], "null"])

for i in range(len(wc["product"])):
    mp = 0
    for c in sc:
        if c["level"] == 3 and wc["product"][i][7] == c["id"]:
            mp = c["name"]
    for c in wc["third_level_category"]:
        if c[2] == mp:
            mp = c[0]
    wc["product"][i][7] = mp

# remove unlinked categories and products
remove_unlinked(wc, "first_level_category", "second_level_category", 1)
remove_unlinked(wc, "second_level_category", "third_level_category", 1)
remove_unlinked(wc, "third_level_category", "product", 7)
remove_unlinked(wc, "product", "product_image", 3)
remove_unlinked(wc, "first_level_category", "property", 2)
remove_unlinked(wc, "property", "property_value", 1)
remove_unlinked(wc, "product", "product_order_item", 3)
remove_unlinked(wc, "product", "review", 4)

with open(path["dest"], "w", encoding="utf-8") as f:
    for s in NISO:
        t = "Records of "+s
        f.write("-- "+"-"*74+" --\n")
        f.write("-- "+(("-"*int((72-len(t))/2)+" "+t+" " + "-" *
                        (int((72-len(t))/2)+(72-len(t)) % 2)) if 72-len(t) > 0 else t) + " --\n")
        f.write("-- "+"-"*74+" --\n")
        for i in wc[s]:
            f.write(IS % s + format_values(i)+";\n")
