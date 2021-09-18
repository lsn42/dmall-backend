package com.example.dmall.service;

import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductImage;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();
    List<Product> findProductsByCategory(Integer Category_id);
    List<ProductImage> findProductSmallImage(Integer product_id);
    List<FirstLevelCategory> getFirstCategory();
}
