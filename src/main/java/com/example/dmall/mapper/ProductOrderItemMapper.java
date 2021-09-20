package com.example.dmall.mapper;

import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductOrder;
import com.example.dmall.bean.ProductOrderItem;
import com.example.dmall.bean.Review;

import java.util.List;

public interface ProductOrderItemMapper {
    List<ProductOrderItem> selectOrderItemByUserId(Integer  id);
    List<ProductOrderItem> selectItemInCart(Integer id);
    List<ProductOrderItem> selectItemByOrderId(Integer id);
    Product selectProductByItem(ProductOrderItem productOrderItem);
    int insertintoOrderItem(ProductOrderItem productOrderItem);
    int deleteOrderItem(Integer id);
    int updateOrderItem(ProductOrderItem productOrderItem);
    int addOrderIdForItem(Integer id,Integer orderId);
    ProductOrderItem selectOrderItemById(Integer id);
    Integer addReviewForItem(Review review);
    Integer newOrder(ProductOrder order);
    Integer changeCount(Integer count,Integer id);
    Integer addMessage(String message,Integer id);
}
