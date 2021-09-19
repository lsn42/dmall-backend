package com.example.dmall.service.impl;

import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.bean.SecondLevelCategory;
import com.example.dmall.bean.ThirdLevelCategory;
import com.example.dmall.mapper.ProductCategoryMapper;
import com.example.dmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public List<Map<String, Object>> getAllCategory() {
        List<Map<String,Object>> res = new ArrayList<>();
        List<FirstLevelCategory> firstLevelCategories = productCategoryMapper.getFirstCategory();
        for(FirstLevelCategory firstLevelCategory: firstLevelCategories) {
            List<Map<String,Object>> temp = new ArrayList<>();
            List<SecondLevelCategory> secondLevelCategories = productCategoryMapper.getSecondCategoryByFirst(firstLevelCategory);
            for (SecondLevelCategory secondLevelCategory:secondLevelCategories) {
                List<ThirdLevelCategory> thirdLevelCategories = productCategoryMapper.getThirdCategoryBySecond(secondLevelCategory);
                Map<String,Object> secondMap = new HashMap<>();
                secondMap.put("category",secondLevelCategory);
                secondMap.put("children",thirdLevelCategories);
                temp.add(secondMap);
            }
            Map<String,Object> firstMap = new HashMap<>();
            firstMap.put("category",firstLevelCategory);
            firstMap.put("children",temp);
            res.add(firstMap);
        }

        return res;
    }
}
