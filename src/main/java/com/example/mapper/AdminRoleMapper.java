package com.example.mapper;

import com.example.bean.Admin;
import com.example.bean.AdminRole;

import java.util.List;

public interface AdminRoleMapper {
    public List<AdminRole> getAdminRoleByAdmin(Admin admin);
}
