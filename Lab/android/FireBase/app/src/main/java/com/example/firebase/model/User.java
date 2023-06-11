package com.example.firebase.model;

public class User {
    private String hoTen;
    private boolean gioiTinh;
    private long tuoi;

    public User() {
    }

    public User(boolean gioiTinh, String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public long getTuoi() {
        return tuoi;
    }

    public void setTuoi(long tuoi) {
        this.tuoi = tuoi;
    }
}
