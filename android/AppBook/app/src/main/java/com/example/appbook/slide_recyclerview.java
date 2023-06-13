package com.example.appbook;

import java.io.Serializable;

public class slide_recyclerview implements Serializable {
   private int image;
    private String text;

    public slide_recyclerview(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
