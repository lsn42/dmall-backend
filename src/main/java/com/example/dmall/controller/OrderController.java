package com.example.dmall.controller;

import com.example.dmall.admin.CheckToken;
import com.example.dmall.admin.JwtUtil;
import com.example.dmall.bean.Msg;
import com.example.dmall.bean.ProductImage;
import com.example.dmall.bean.ProductOrder;
import com.example.dmall.bean.ProductOrderItem;
import com.example.dmall.service.OrderService;
import com.example.dmall.service.ProductOrderItemService;
import com.example.dmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductOrderItemService productOrderItemService;
    @Autowired
    ProductService productService;
    @RequestMapping("/pay/{id}")
    public Msg pay(@PathVariable(value = "id") Integer id,
                   @RequestHeader(value = "token") String token) {
        Integer userId = JwtUtil.getUserId(token);
        Integer res = orderService.pay(id);
        if(res<0) {
            return Msg.fail();
        }return Msg.success();
    }

    @RequestMapping("/deliver/{id}")
    public Msg deliver(@PathVariable(value = "id") Integer id,
                   @RequestHeader(value = "token") String token) {
        Integer userId = JwtUtil.getUserId(token);
        Integer res = orderService.deliver(id);
        if(res<0) {
            return Msg.fail();
        }return Msg.success();
    }

    @RequestMapping("/confirm/{id}")
    public Msg confirm(@PathVariable(value = "id") Integer id,
                   @RequestHeader(value = "token") String token) {
        Integer userId = JwtUtil.getUserId(token);
        Integer res = orderService.confirm(id);
        if(res<0) {
            return Msg.fail();
        }return Msg.success();
    }

    @RequestMapping("/allOrder")
    @CheckToken
    public Msg allOrder(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrder> productOrders = orderService.allOrder(id);
        List<Map<String,Object>> list = getOrders(productOrders);
        return new Msg().success("orders",list);
    }

    @RequestMapping("/unpaidOrder")
    @CheckToken
    public Msg unpaidOrder(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrder> productOrders = orderService.unpaidOrder(id);
        List<Map<String,Object>> list = getOrders(productOrders);
        return new Msg().success("orders",list);
    }

    @RequestMapping("/deliveringOrder")
    @CheckToken
    public Msg deliveringOrder(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrder> productOrders = orderService.deliveringOrder(id);
        List<Map<String,Object>> list = getOrders(productOrders);
        return new Msg().success("orders",list);
    }

    @RequestMapping("/unconfirmedOrder")
    @CheckToken
    public Msg unconfirmedOrder(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrder> productOrders = orderService.unconfirmedOrder(id);
        List<Map<String,Object>> list = getOrders(productOrders);
        return new Msg().success("orders",list);
    }

    @RequestMapping("/confirmedOrder")
    @CheckToken
    public Msg confirmedOrder(@RequestHeader(value = "token")String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrder> productOrders = orderService.confirmedOrder(id);
        List<Map<String,Object>> list = getOrders(productOrders);
        return new Msg().success("orders",list);
    }


    public List<Map<String,Object>> getOrders(List<ProductOrder> productOrders){
        List<Map<String,Object>> list = new ArrayList<>();
        if(productOrders==null) {
            productOrders=new ArrayList<>();
        }
        for (ProductOrder productOrder:productOrders) {
            List<ProductOrderItem> productOrderItems = productOrderItemService.selectItemByOrderId(productOrder.getId());
            for (ProductOrderItem productOrderItem:productOrderItems) {
                List<ProductImage> productImages = productService.findProductSmallImage(productOrderItem.getProductId());
                if(productImages!=null&&productImages.size()>0){
                    productOrderItem.setImgSrc(productImages.get(0).getSrc());
                }
            }
            Map<String,Object> map = new HashMap<>();
            map.put("order",productOrder);
            map.put("items",productOrderItems);
            list.add(map);
        }
        return list;
    }
}
