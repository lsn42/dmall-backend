package com.example.dmall.bean;

public class UserAddress {
    private Integer userId;
    private Integer areaId;
    private String detailAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "userId=" + userId +
                ", areaId=" + areaId +
                ", detailAddress='" + detailAddress + '\'' +
                '}';
    }
}
