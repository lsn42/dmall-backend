package com.example.service;

import com.example.bean.Admin;
import com.example.bean.AdminRole;

import java.util.List;

public interface AdminRoleService {
     public List<AdminRole> getAdminRoleByAdminId(Admin admin);
}
