package com.example.dmall.bean;

public class ProductImage {
    private Integer id;
    private Integer type;
    private String src;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", type=" + type +
                ", src='" + src + '\'' +
                ", productId=" + productId +
                '}';
    }
}
