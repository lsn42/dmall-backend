package com.example.dmall.controller;

import com.example.dmall.bean.ProductOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Mycontroller {

    @RequestMapping("/tt")
    public Object doSome(@RequestBody ProductOrder order) {

        System.out.println(order.toString());
        return "helloworld";
    }

}
