package com.example.tuan12_1;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class NhanVien extends BaseObservable {
    private String MaNV, TenNV;
    private Boolean sex;

    private  Boolean delete = false;

    @Bindable
    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
        notifyPropertyChanged(BR.delete);
    }

    public NhanVien(String maNV, String tenNV, Boolean sex) {
        MaNV = maNV;
        TenNV = tenNV;
        this.sex = sex;
    }

    @Bindable
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
        notifyPropertyChanged(BR.maNV);
    }

    @Bindable
    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
        notifyPropertyChanged(BR.tenNV);
    }

    @Bindable
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }
}
