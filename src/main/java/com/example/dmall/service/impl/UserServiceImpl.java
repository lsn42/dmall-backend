package com.example.dmall.service.impl;

import com.example.dmall.bean.User;
import com.example.dmall.mapper.UserMapper;
import com.example.dmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryByNameAndPwd(String name, String password) {
        return userMapper.queryByNameAndPwd(name,password);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
