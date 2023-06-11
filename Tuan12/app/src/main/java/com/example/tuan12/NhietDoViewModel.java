package com.example.tuan12;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class NhietDoViewModel extends BaseObservable {
    private boolean isDok = false;
    private int nhietdo = 0;

    @Bindable
    public boolean isDok() {
        return isDok;
    }

    public void setDok(boolean dok) {
        isDok = dok;
        notifyPropertyChanged(BR.ketQua);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public int getNhietdo() {
        return nhietdo;
    }

    public void setNhietdo(int nhietdo) {
        this.nhietdo = nhietdo;
        notifyPropertyChanged(BR.ketQua);
    }

    @Bindable
    public int getKetQua() {
        if (isDok) {
            return nhietdo - 273;
        } else
            return nhietdo + 273;
    }

    @Bindable
    public String getTitle() {
        if (isDok) {
            return "Đổi từ độ K sang độ C";
        }
            return "Đổi từ độ C sang độ K";
    }
}
