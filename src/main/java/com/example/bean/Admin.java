package com.example.bean;

public class Admin {
    private int id;
    private String name;
    private int status;
    private String nickName;
    private String password;
    private String profilePictureSrc;
    private int del;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePictureSrc() {
        return profilePictureSrc;
    }

    public void setProfilePictureSrc(String profilePictureSrc) {
        this.profilePictureSrc = profilePictureSrc;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", profilePictureSrc='" + profilePictureSrc + '\'' +
                ", del=" + del +
                '}';
    }
}
