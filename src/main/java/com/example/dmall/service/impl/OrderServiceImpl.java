package com.example.dmall.service.impl;

import com.example.dmall.bean.ProductOrder;
import com.example.dmall.mapper.OrderMapper;
import com.example.dmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public Integer pay(Integer id) {
        return orderMapper.pay(id);
    }

    @Override
    public Integer deliver(Integer id) {
        return orderMapper.deliver(id);
    }

    @Override
    public Integer confirm(Integer id) {
        return orderMapper.confirm(id);
    }

    @Override
    public List<ProductOrder> allOrder(Integer id) {
        return orderMapper.allOrder(id);
    }

    @Override
    public List<ProductOrder> unpaidOrder(Integer id) {
        return orderMapper.unpaidOrder(id);
    }

    @Override
    public List<ProductOrder> deliveringOrder(Integer id) {
        return orderMapper.deliveringOrder(id);
    }

    @Override
    public List<ProductOrder> unconfirmedOrder(Integer id) {
        return orderMapper.unconfirmedOrder(id);
    }

    @Override
    public List<ProductOrder> confirmedOrder(Integer id) {
        return orderMapper.confirmedOrder(id);
    }
}
