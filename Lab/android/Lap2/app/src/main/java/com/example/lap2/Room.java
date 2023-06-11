package com.example.lap2;

import java.io.Serializable;

public class Room implements Serializable {
    private int image;
    private String name,description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public Room(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }
}
