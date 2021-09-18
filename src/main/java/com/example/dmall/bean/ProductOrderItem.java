package com.example.dmall.bean;

import java.math.BigDecimal;

public class ProductOrderItem {
    private Integer id;
    private Integer count;
    private BigDecimal price;
    private Integer productId;
    private Integer orderId;
    private Integer userId;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ProductOrderItem{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }
}
