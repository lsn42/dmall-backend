package com.example.dmall.bean;

public class Permission {
    private Integer id;
    private String title;
    private String icon;
    private String link;
    private String type;
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", link='" + link + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
