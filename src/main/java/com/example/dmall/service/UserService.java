package com.example.dmall.service;

import com.example.dmall.bean.User;

public interface UserService {
    public User queryByNameAndPwd(String name,String password);
    public Integer addUser(User user);
    public User findById(Integer id);
}
