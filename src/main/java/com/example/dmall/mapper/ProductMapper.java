package com.example.dmall.mapper;

import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductImage;
import com.example.dmall.bean.Property;
import com.example.dmall.bean.PropertyValue;

import java.util.List;

public interface ProductMapper{
    List<Product> findProducts();

    //根据类别的id查找产品信息,这是自己写的接口，没有利用mybatisplus
    List<Product>findProductsByCategory(Integer category_id);
    List<ProductImage> findProductSmallImage(Integer product_id);
    List<Product> findAllByFirstLevelCategory(Integer category_id);
    List<Product> findAllByThirdLevelCategory(Integer category_id);
    Product getProductById(Integer id);
    Integer getReviewCount(Integer id);
    Integer getBuyCount(Integer id);
    List<PropertyValue> getPropertyValue(Integer id);
    Property getProperty(Integer id);
    List<Product> getProductByParam(String param);
}