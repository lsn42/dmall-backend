package com.example.dmall.controller;

import com.example.dmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {
    @Autowired
    UserService userService;

//    @RequestMapping("/login")
}
