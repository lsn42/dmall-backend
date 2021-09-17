package com.example.controller;

import com.example.bean.Admin;
import com.example.bean.Msg;
import com.example.service.AdminRoleService;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRoleService adminRoleService;
    public AdminController(AdminService adminService){this.adminService =adminService;}


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public Msg login(@RequestParam(value="name") String name,
                       @RequestParam(value = "password") String password) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        if(adminService.findByNameAndPwd(admin)){
            return Msg.success();
        }
        return Msg.fail();
    }

    @RequestMapping(value="/test")
    public Object test(){
        System.out.println("shuchudianshenme");
        return "helloword";
    }
    @RequestMapping("/")
    public Object test2(){
        System.out.println("shuchudianshenme");
        return "goodbyeworld";
    }
    @RequestMapping(value ="/getAdminRole",method = {RequestMethod.GET})
    public Msg getAdminRole() {
        Admin admin = new Admin();
        admin.setId(1);
        Msg msg = new Msg();
        return msg.success("AdminRoles",adminRoleService.getAdminRoleByAdminId(admin));
    }
}
