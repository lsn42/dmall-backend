package com.example.dmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @RequestMapping("/tt")
    public Object doSome() {
        return "helloworld";
    }

}
