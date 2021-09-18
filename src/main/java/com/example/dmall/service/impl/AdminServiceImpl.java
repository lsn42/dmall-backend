package com.example.dmall.service.impl;

import com.example.dmall.bean.Admin;
import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.mapper.AdminMapper;
import com.example.dmall.mapper.AdminRoleMapper;
import com.example.dmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Boolean findByNameAndPwd(Admin admin) {
        Admin admin1 = adminMapper.queryByNameAndPwd(admin);
        if(admin1 != null) {
            return  true;
        }
        return false;
    }

    @Override
    public Admin getAdminByNameAndPwd(Admin admin) {
        Admin admin1 = adminMapper.queryByNameAndPwd(admin);
        if(admin1 != null) {
            return admin1;
        }
        return null;
    }


}
