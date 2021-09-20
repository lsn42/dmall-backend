package com.example.dmall.controller;


import com.example.dmall.admin.CheckToken;
import com.example.dmall.admin.JwtUtil;
import com.example.dmall.bean.Msg;
import com.example.dmall.bean.ProductOrder;
import com.example.dmall.bean.ProductOrderItem;
import com.example.dmall.bean.Review;
import com.example.dmall.mapper.ProductOrderItemMapper;
import com.example.dmall.service.ProductOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orderItem")
public class ProductOrderItemController {
    @Autowired
    ProductOrderItemService productOrderItemService;

    @RequestMapping(value = "/fromUser")
    @CheckToken
    public Msg fromUser(@RequestHeader(value = "token") String token) {
        Integer id = JwtUtil.getUserId(token);
        List<ProductOrderItem> productOrderItems = productOrderItemService.selectOrderItemByUserId(id);
        return new Msg().success("items",productOrderItems);
    }

    @RequestMapping(value="/reviewItem/{itemId}")
    @CheckToken
    public Msg reviewItem(@RequestHeader(value = "token") String token,
                          @RequestParam (value = "review") String review,
                          @PathVariable(value = "itemId") Integer itemId) {
        Integer id = JwtUtil.getUserId(token);
        ProductOrderItem productOrderItem =productOrderItemService.selectOrderItemById(itemId);
        if(id!=productOrderItem.getUserId()) {
            return Msg.error("该物品不在用户购物篮中");
        }
        Timestamp createDate = new Timestamp(System.currentTimeMillis());
        Review review1 = new Review();
        review1.setContent(review);
        review1.setCreateDate(createDate);
        review1.setOrderItemId(productOrderItem.getId());
        review1.setProductId(productOrderItem.getProductId());
        review1.setUserId(productOrderItem.getUserId());
        review1.setId(-1);
        Integer res = productOrderItemService.addReviewForItem(review1);
        if(res>0) {
            return new Msg().success("reviewId",res);
        }
        return Msg.error("添加失败，请稍后再试");
    }

    @RequestMapping(value = "/newOrder")
    @CheckToken
    public Msg addItemsToOrder(@RequestBody ProductOrder order,
                               @RequestHeader(value = "token")String token){
        try{
            order.setCode(executes());
            order.setCreateDate(new Timestamp(System.currentTimeMillis()));
            order.setStatus(0);
            order.setUserId(JwtUtil.getUserId(token));
            Integer id=productOrderItemService.addIntoOrder(order);
            if(id<0){
                return Msg.error("新建订单失败");
            }return new Msg().success("id",id);

        }catch(Exception e) {
            return  Msg.error("数据库错误");
        }

    }

    @RequestMapping(value = "/changeCount/{count}/{id}")
    @CheckToken
    public Msg changeCount(@PathVariable(value="count") Integer count,
                            @PathVariable(value="id") Integer id,
                           @RequestHeader(value="token") String token){
        Integer userId = JwtUtil.getUserId(token);
        ProductOrderItem item = productOrderItemService.selectOrderItemById(id);
        if(item.getUserId().equals(userId)){
            if(productOrderItemService.changeCount(count,id)>0){
                return  Msg.success();
            }else return Msg.error("访问数据库失败，请稍后重试");
        }return Msg.error("购物车中没有该物品");
    }

    @RequestMapping(value = "/cart")
    @CheckToken
    public Msg cart(@RequestHeader(value = "token") String token) {
        Integer id = JwtUtil.getUserId(token);
        return new Msg().success("items",productOrderItemService.selectItemInCart(id));
    }

    @RequestMapping(value = "/deleteItem/{id}")
    @CheckToken
    public Msg deleteItem(@PathVariable(value = "id")Integer id,
                          @RequestHeader(value = "token") String token) {
        if(productOrderItemService.deleteOrderItem(id)<0){
            return Msg.fail();
        }return Msg.success();

    }

    @RequestMapping(value = "addItem")
    @CheckToken
    public Msg addItem(@RequestBody ProductOrderItem productOrderItem,
                       @RequestHeader(value = "token") String token) {
        Integer id = productOrderItemService.insertintoOrderItem(productOrderItem);
        if(id<0){
            return Msg.fail();
        }return new Msg().success("id",id);
    }

    @RequestMapping(value = "addMesage/{id}")
    @CheckToken
    public Msg addMessage(@RequestHeader(value = "token") String token,
                          @RequestBody String message,
                          @PathVariable Integer id) {
        Integer res = productOrderItemService.addMessage(message,id);
        if(res<0) return Msg.fail();
        return Msg.success();
    }
    public static String executes() {
        String prefix = "DN";
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        int random = new Random().nextInt(90) + 10;   //两位数字的随机数
        String value = prefix + format.format(new Date()) + random;
        return value;
    }
}
