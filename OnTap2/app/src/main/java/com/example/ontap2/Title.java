package com.example.ontap2;

import java.io.Serializable;

public class Title implements Serializable {
    private String code,name,image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Title(String code, String name, String image) {

        this.code = code;
        this.name = name;
        this.image = image;
    }
}
