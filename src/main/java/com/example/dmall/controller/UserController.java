package com.example.dmall.controller;

import com.example.dmall.admin.CheckToken;
import com.example.dmall.admin.JwtUtil;
import com.example.dmall.bean.Msg;
import com.example.dmall.bean.UserAddress;
import com.example.dmall.mapper.AddressMapper;
import com.example.dmall.service.AddressService;
import com.example.dmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @RequestMapping("/addAddress")
    @CheckToken
    public Msg addUserAddress(@RequestHeader(value = "token")String token,
                              @RequestBody UserAddress userAddress){
        Integer res = addressService.addUserAddress(userAddress);
        if(res==null||res<0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping("/getAddress")
    @CheckToken
    public Msg getAddress(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<UserAddress> userAddresses = addressService.getUserAddress(id);
        if (userAddresses==null) return Msg.fail();
        return new Msg().success("addresses",userAddresses);
    }

    @RequestMapping("/deleteAddress")
    @CheckToken
    public Msg deleteAddress(@RequestHeader(value = "token")String token,
                             @RequestBody UserAddress userAddress) {
        Integer res = addressService.deleteAddress(userAddress);
        if(res==null || res<0) return  Msg.fail();
        return  Msg.success();
    }

    @RequestMapping("/updateAddress")
    @CheckToken
    public Msg updateAddress(@RequestHeader(value = "token")String token,
                             @RequestBody UserAddress userAddress) {
        Integer res = addressService.updateAddress(userAddress);
        if(res==null || res<0) return  Msg.fail();
        return  Msg.success();
    }


//    @RequestMapping("/login")
}
