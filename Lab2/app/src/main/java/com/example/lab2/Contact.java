package com.example.lab2;

public class Contact {
    private String name,phone;
    private  int hinh;
public Contact(){}
    public Contact(String name, String phone, int hinh) {
        this.name = name;
        this.phone = phone;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
