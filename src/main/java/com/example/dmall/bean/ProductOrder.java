package com.example.dmall.bean;

import java.sql.Timestamp;

public class ProductOrder {
    private Integer id;
    private String code;
    private  String address;
    private String detailAddress;
    private String post;
    private String receiver;
    private String phone;
    private Timestamp createDate;
    private  Timestamp payDate;
    private Timestamp deliveryDate;
    private Timestamp confirmDate;
    private Boolean status;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", post='" + post + '\'' +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", createDate=" + createDate +
                ", payDate=" + payDate +
                ", deliveryDate=" + deliveryDate +
                ", confirmDate=" + confirmDate +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
