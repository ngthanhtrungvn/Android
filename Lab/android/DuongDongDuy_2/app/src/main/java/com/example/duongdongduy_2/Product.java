package com.example.duongdongduy_2;

import java.io.Serializable;

public class Product implements Serializable {
    String code,name;
    String price;
    String image;

    public Product(String code, String name, String price, String image) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
