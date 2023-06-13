package com.example.appbook;

import java.io.Serializable;

public class Book implements Serializable {
   private String image;
   private String text;
   private double price;
   private  String code;
   private  String moTa;

    public Book(String image, String text, double price, String code, String moTa) {
        this.image = image;
        this.text = text;
        this.price = price;
        this.code = code;
        this.moTa = moTa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
