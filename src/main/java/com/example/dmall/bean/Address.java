package com.example.dmall.bean;

public class Address {
    private String name;
    private String areaId;
    private String regionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", areaId='" + areaId + '\'' +
                ", regionId='" + regionId + '\'' +
                '}';
    }
}
