package com.example.mapper;

import com.example.bean.Admin;

public interface AdminMapper {
    public Admin queryByNameAndPwd(Admin admin);
}
