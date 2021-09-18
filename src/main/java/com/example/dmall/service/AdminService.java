package com.example.dmall.service;

import com.example.dmall.bean.Admin;

public interface AdminService {
    Boolean findByNameAndPwd(Admin admin);
    Admin getAdminByNameAndPwd(Admin admin);
}
