package com.example.truyencuoi.model;

import android.graphics.Bitmap;
import android.net.Uri;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.truyencuoi.BR;

import java.sql.Blob;

public class topics extends BaseObservable {
    private int id;
    @Bindable
    private String name;
    @Bindable
    private Bitmap image;

    public topics(int id, String name, Bitmap image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;        notifyPropertyChanged(BR.name);

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
        notifyPropertyChanged(BR.image);

    }


}
