package com.example.reccylclerviewexample;

import java.io.Serializable;

public class Country implements Serializable {
   private int flag;
   private String name,population;

    public Country(int flag, String name, String population) {
        this.flag = flag;
        this.name = name;
        this.population = population;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
