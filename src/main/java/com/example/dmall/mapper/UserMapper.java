package com.example.dmall.mapper;

import com.example.dmall.bean.User;

public interface UserMapper {
    public User queryByNameAndPwd(String name,String password);
    public Integer addUser(User user);
    public User findById(Integer id);
}
