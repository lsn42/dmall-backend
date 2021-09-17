package com.example.dmall.mapper;

import com.example.dmall.bean.Admin;

public interface AdminMapper {
    public Admin queryByNameAndPwd(Admin admin);
}
