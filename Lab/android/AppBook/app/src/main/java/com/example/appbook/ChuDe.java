package com.example.appbook;

public class ChuDe {
    private String ma,ten,hinh;

    public ChuDe(String ma, String ten, String hinh) {
        this.ma = ma;
        this.ten = ten;
        this.hinh = hinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
