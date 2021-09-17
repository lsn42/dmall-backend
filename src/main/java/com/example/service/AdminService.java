package com.example.service;

import com.example.bean.Admin;

public interface AdminService {
    Boolean findByNameAndPwd(Admin admin);
}
