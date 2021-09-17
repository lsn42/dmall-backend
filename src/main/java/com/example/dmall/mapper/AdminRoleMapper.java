package com.example.dmall.mapper;

import com.example.dmall.bean.Admin;
import com.example.dmall.bean.AdminRole;

import java.util.List;

public interface AdminRoleMapper {
    public List<AdminRole> getAdminRoleByAdmin(Admin admin);
}
