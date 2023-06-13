package com.example.listfruit;

public class Fruit {
    String name,description;
    int image;

    public Fruit(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Fruit() {
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
