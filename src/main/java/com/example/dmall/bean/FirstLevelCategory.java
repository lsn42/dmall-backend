package com.example.dmall.bean;

public class FirstLevelCategory {
    private Integer id;
    private String name;
    private String imageSrc;

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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public String toString() {
        return "FirstLevelCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}
