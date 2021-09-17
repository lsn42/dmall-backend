package com.example.bean;

public class AdminRole {
    private int AdminId;
    private int RoleId;

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
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
