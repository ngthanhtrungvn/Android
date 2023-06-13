package com.example.ontapkiemtralan2;

import java.io.Serializable;

public class Book implements Serializable {
    private String code,name;
    private  double price;
    private  String description,image;

    public Book(String code, String name, double price, String description, String image) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
