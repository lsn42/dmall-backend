package com.example.dmall.controller;

import com.example.dmall.bean.Advertisement;
import com.example.dmall.bean.Msg;
import com.example.dmall.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping("/ad")
    public Msg getAllAdvertisement(){
        Msg msg = new Msg();
        List<Advertisement> advertisements = advertisementService.getAllAdvertisement();
        return msg.success("advertisements",advertisements);
    }
}
