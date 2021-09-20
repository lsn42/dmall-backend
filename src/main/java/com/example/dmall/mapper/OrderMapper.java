package com.example.dmall.mapper;

import com.example.dmall.bean.ProductOrder;

import java.util.List;

public interface OrderMapper {
    Integer pay(Integer id);
    Integer deliver(Integer id);
    Integer confirm(Integer id);
    List<ProductOrder> allOrder(Integer id);
    List<ProductOrder> unpaidOrder(Integer id);
    List<ProductOrder> deliveringOrder(Integer id);
    List<ProductOrder> unconfirmedOrder(Integer id);
    List<ProductOrder> confirmedOrder(Integer id);
}
