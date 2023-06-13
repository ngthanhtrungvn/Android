package com.example.test;

import java.io.Serializable;

public class Book implements Serializable {
    int imgBook;
    String code,name,description;
    double price;
    boolean status;

    public Book(int imgBook, String code, String name, String description, double price) {
        this.imgBook = imgBook;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status=false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getImgBook() {
        return imgBook;
    }

    public void setImgBook(int imgBook) {
        this.imgBook = imgBook;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
