package com.example.service.impl;

import com.example.bean.Admin;
import com.example.bean.AdminRole;
import com.example.mapper.AdminRoleMapper;
import com.example.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    AdminRoleMapper adminRoleMapper;
    public List<AdminRole> getAdminRoleByAdminId(Admin admin) {
        List<AdminRole> adminRoles = adminRoleMapper.getAdminRoleByAdmin(admin);
        return  adminRoles;
    }
}
