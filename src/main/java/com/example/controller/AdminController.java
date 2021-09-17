package com.example.controller;

import com.example.bean.Admin;
import com.example.bean.Msg;
import com.example.service.AdminRoleService;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
//    @Autowired
//    private AdminRoleService adminRoleService;
    public AdminController(AdminService adminService){this.adminService =adminService;}

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public Msg doLogin(Admin admin) {
        if(adminService.findByNameAndPwd(admin)){
            return Msg.success();
        }
        return Msg.fail();
    }

//    @RequestMapping(value ="/getAdminRole",method = {RequestMethod.GET})
//    public Msg getAdminRole() {
//        Admin admin = new Admin();
//        Msg msg = new Msg();
//        return msg.success("AdminRoles",adminRoleService.getAdminRoleByAdminId(admin));
//    }
}
