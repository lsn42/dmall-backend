package com.example.dmall.service.impl;

import com.example.dmall.bean.Admin;
import com.example.dmall.bean.AdminRole;
import com.example.dmall.mapper.AdminRoleMapper;
import com.example.dmall.service.AdminRoleService;
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
