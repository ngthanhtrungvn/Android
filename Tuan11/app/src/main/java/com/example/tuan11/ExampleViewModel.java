package com.example.tuan11;

import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ExampleViewModel extends BaseObservable {
    private String demoText;

    @Bindable
    public String getDemoText() {
        return demoText;
    }

    public void setDemoText(String demoText) {
        this.demoText = demoText;
    }

    public void HayClickDi(View view) {
        demoText = demoText.toUpperCase();
        Log.e("Demo text", demoText);
        notifyPropertyChanged(BR.demoText);
    }


}
