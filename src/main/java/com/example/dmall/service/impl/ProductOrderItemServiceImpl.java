package com.example.dmall.service.impl;

import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductOrder;
import com.example.dmall.bean.ProductOrderItem;
import com.example.dmall.bean.Review;
import com.example.dmall.mapper.ProductOrderItemMapper;
import com.example.dmall.service.ProductOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductOrderItemServiceImpl implements ProductOrderItemService {
    @Autowired
    ProductOrderItemMapper productOrderItemMapper;

    @Override
    public List<ProductOrderItem> selectOrderItemByUserId(Integer id) {
        return productOrderItemMapper.selectOrderItemByUserId(id);
    }

    @Override
    public List<ProductOrderItem> selectItemInCart(Integer id) {
        return productOrderItemMapper.selectItemInCart(id);
    }

    @Override
    public List<ProductOrderItem> selectItemByOrderId(Integer id) {
        return productOrderItemMapper.selectItemByOrderId(id);
    }

    @Override
    public Product selectProductByItem(ProductOrderItem productOrderItem) {
        return productOrderItemMapper.selectProductByItem(productOrderItem);
    }

    @Override
    public int insertIntoOrderItem(ProductOrderItem productOrderItem) {
        Integer res = productOrderItemMapper.insertIntoOrderItem(productOrderItem);
        if(res<0) return -1;
        return productOrderItem.getId();
    }

    @Override
    public int deleteOrderItem(Integer id) {
        return productOrderItemMapper.deleteOrderItem(id);
    }

    @Override
    public int updateOrderItem(ProductOrderItem productOrderItem) {
        return productOrderItemMapper.updateOrderItem(productOrderItem);
    }

    @Override
    public int addOrderIdForItem(Integer id, Integer orderId) {
        return productOrderItemMapper.addOrderIdForItem(id,orderId);
    }

    @Override
    public ProductOrderItem selectOrderItemById(Integer id) {
        return productOrderItemMapper.selectOrderItemById(id);
    }

    @Override
    public Integer addReviewForItem(Review review) {
        return productOrderItemMapper.addReviewForItem(review);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Integer addIntoOrder(ProductOrder order) throws Exception {
        List<Integer> items = order.getItems();
        Integer res = productOrderItemMapper.newOrder(order);

        if(res<0) return -1;
        for(Integer id:items) {
            Integer res1 = productOrderItemMapper.addOrderIdForItem(id,order.getId());
            if(res1<0) {throw new Exception();}
        }
        return order.getId();
    }

    @Override
    public Integer changeCount(BigDecimal price, Integer count, Integer id) {
        return productOrderItemMapper.changeCount(price,count,id);
    }

    @Override
    public Integer addMessage(String message, Integer id) {
        return productOrderItemMapper.addMessage(message,id);
    }

    @Override
    public Review getReview(Integer itemId, Integer userId) {
        return productOrderItemMapper.getReviewByItemId(itemId,userId);
    }

}
