package com.example.dmall.controller;

import com.example.dmall.bean.Admin;
import com.example.dmall.bean.AdminRole;
import com.example.dmall.bean.Msg;
import com.example.dmall.service.AdminRoleService;
import com.example.dmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Msg getAdminRole(@RequestParam(value = "id",defaultValue = "1") int id) {
        Admin admin = new Admin();
        admin.setId(id);
        Msg msg = new Msg();

        List<AdminRole> adminRoles = adminRoleService.getAdminRoleByAdminId(admin);
        System.out.println(adminRoles);
        return msg.success("AdminRoles",adminRoles);
    }

    @RequestMapping(value="/testReturn")
    public Msg getAdminRole(@RequestParam(value="name") String name,
                            @RequestParam(value="password") String password) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        admin = adminService.getAdminByNameAndPwd(admin);
        return null;
    }
}
