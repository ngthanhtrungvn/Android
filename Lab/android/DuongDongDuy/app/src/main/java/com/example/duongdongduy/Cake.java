package com.example.duongdongduy;

import java.io.Serializable;

public class Cake implements Serializable {
  private   String name,quantity;
    private int image;

    public Cake(String name, String quantity, int image) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
