package com.example.dmall.service.impl;

import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductImage;
import com.example.dmall.mapper.ProductCategoryMapper;
import com.example.dmall.mapper.ProductMapper;
import com.example.dmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<Product> listAllProduct() {
        List<Product> productList= productMapper.findProducts();
        return productList;
    }

    @Override
    public List<Product> findProductsByCategory(Integer category_id) {
        List<Product> productList =productMapper.findProductsByCategory(category_id);
        return productList;
    }

    @Override
    public List<ProductImage> findProductSmallImage(Integer product_id) {
        return productMapper.findProductSmallImage(product_id);
    }

    @Override
    public List<FirstLevelCategory> getFirstCategory(){
        return productCategoryMapper.getFirstCategory();
    }
}