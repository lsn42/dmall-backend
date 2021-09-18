package com.example.dmall.bean;

import java.sql.Date;

public class User {
    private Integer id;
    private String name;
    private String nickname;
    private String password;
    private Integer status;
    private String realname;
    private Boolean gender;
    private Date birthday;
    private String address;
    private String homeplace;
    private String profilePictureSrc;
    private String phone;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }

    public String getProfilePictureSrc() {
        return profilePictureSrc;
    }

    public void setProfilePictureSrc(String profilePictureSrc) {
        this.profilePictureSrc = profilePictureSrc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", realname='" + realname + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", homeplace='" + homeplace + '\'' +
                ", profilePictureSrc='" + profilePictureSrc + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
