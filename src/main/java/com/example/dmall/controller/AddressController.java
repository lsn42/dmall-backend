package com.example.dmall.controller;

import com.example.dmall.bean.Msg;
import com.example.dmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService){this.addressService = addressService;}

    @RequestMapping(value = "/getAddress/{regionId}")
    public Msg getAddress(@PathVariable(value ="regionId",required=true) Integer regionId){
        Msg msg = new Msg();
        return  msg.success("Address",addressService.getAddressByRegionId(regionId));
    }

    @RequestMapping(value="firstAddress")
    public Msg firstAddress(){
        Msg msg = new Msg();
        return  msg.success("Address",addressService.firstAddress());
    }
}
