package com.example.dmall.service;

import com.example.dmall.bean.*;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();
    List<Product> findProductsByCategory(Integer Category_id);
    List<ProductImage> findProductSmallImage(Integer product_id);
    List<FirstLevelCategory> getFirstCategory();
    List<Product> findAllByFirstLevelCategory(Integer category_id);
    List<Product> findAllByThirdLevelCategory(Integer category_id);
    Product getProductById(Integer id);
    Integer getReviewCount(Integer id);
    Integer getBuyCount(Integer id);
    List<PropertyValue> getPropertyValue(Integer id);
    Property getProperty(Integer id);
    List<Product> getProductByParam(String param);
}
