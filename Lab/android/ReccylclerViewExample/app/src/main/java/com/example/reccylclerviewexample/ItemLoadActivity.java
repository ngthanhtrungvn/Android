package com.example.reccylclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemLoadActivity extends AppCompatActivity {

    ImageView imgFlag;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_load);
        mapping();
        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("country");
        imgFlag.setImageResource(country.getFlag());
        txtName.setText(country.getName());
    }

    private void mapping() {
        imgFlag = findViewById(R.id.imgFlag1);
        txtName = findViewById(R.id.txtName1);
    }
}