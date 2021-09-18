package com.example.dmall.bean;

public class PropertyValue {
    private Integer productId;
    private Integer propertyId;
    private String value;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "productId=" + productId +
                ", propertyId=" + propertyId +
                ", value='" + value + '\'' +
                '}';
    }
}
