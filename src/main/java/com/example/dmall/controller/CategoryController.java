package com.example.dmall.controller;

import com.example.dmall.bean.Msg;
import com.example.dmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/productCategories")
    public Msg productCategories(){
        return new Msg().success("categories",productCategoryService.getAllCategory());
    }
}
