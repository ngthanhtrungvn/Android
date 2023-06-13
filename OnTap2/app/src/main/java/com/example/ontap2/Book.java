package com.example.ontap2;

import java.io.Serializable;

public class Book implements Serializable {
    String code,name;
    double price;
    String image;
    String description;

    public Book(String code, String name, double price, String image, String description) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
