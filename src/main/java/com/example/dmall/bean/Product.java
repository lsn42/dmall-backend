package com.example.dmall.bean;

import com.baomidou.mybatisplus.annotation.TableField;

import java.sql.Timestamp;

public class Product {
    private Integer id;
    private String name;
    private String title;
    private Integer count;
    private Double price;
    private Double salePrice;
    private Timestamp createDate;
    private Integer categoryId;
    private Boolean isEnabled;
    private Integer score;
    private Integer del;
    @TableField(exist=false)  //使用注解排除和数据库中表不对应的字段，该字段的主要功能是因为在查询产品信息的时候，还希望查询出产品的图片，而产品的图片存放在另外的表中，所以，为了方便在这里定义该字段。
    private String smallimage;
    @TableField(exist = false)
    private Integer reviewCount;
    @TableField(exist = false)
    private Integer buyCount;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getSmallimage() {
        return smallimage;
    }

    public void setSmallimage(String smallimage) {
        this.smallimage = smallimage;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", createDate=" + createDate +
                ", categoryId=" + categoryId +
                ", isEnabled=" + isEnabled +
                ", score=" + score +
                ", del=" + del +
                ", smallimage='" + smallimage + '\'' +
                ", reviewCount=" + reviewCount +
                ", buyCount=" + buyCount +
                '}';
    }
}
