package com.example.dmall.service;

import com.example.dmall.bean.Admin;
import com.example.dmall.bean.AdminRole;

import java.util.List;

public interface AdminRoleService {
     public List<AdminRole> getAdminRoleByAdminId(Admin admin);
}
