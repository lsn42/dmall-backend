package com.example.dmall.service.impl;

import com.example.dmall.bean.*;
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
    @Override
    public List<Product> findAllByFirstLevelCategory(Integer category_id) {
        return productMapper.findAllByFirstLevelCategory(category_id);
    };
    public List<Product> findAllByThirdLevelCategory(Integer category_id) {
        return productMapper.findAllByThirdLevelCategory(category_id);
    };

    @Override
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    @Override
    public Integer getReviewCount(Integer id) {
        return productMapper.getReviewCount(id);
    }

    @Override
    public Integer getBuyCount(Integer id) {
        return productMapper.getBuyCount(id);
    }

    @Override
    public List<PropertyValue> getPropertyValue(Integer id) {
        return productMapper.getPropertyValue(id);
    }

    @Override
    public Property getProperty(Integer id) {
        return productMapper.getProperty(id);
    }

    @Override
    public List<Product> getProductByParam(String param) {
        return productMapper.getProductByParam(param);
    }

    @Override
    public List<Review> getReviewsByProduct(Integer id) {
        return productMapper.getReviewsByProduct(id);
    }


}