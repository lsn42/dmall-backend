package com.example.dmall.bean;

public class AdminRole {
    private Integer AdminId;
    private Integer RoleId;

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer adminId) {
        AdminId = adminId;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "AdminId=" + AdminId +
                ", RoleId=" + RoleId +
                '}';
    }
}
