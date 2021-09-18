package com.example.dmall.bean;

public class Admin {
    private Integer id;
    private String name;
    private Integer status;
    private String nickName;
    private String password;
    private String profilePictureSrc;
    private Integer del;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
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
