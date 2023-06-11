package com.example.duongdongduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemLoadActivity extends AppCompatActivity {

    Button btnBack;
    TextView name;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_load);
        mapping();
        Intent intent=getIntent();
        Cake cake= (Cake) intent.getSerializableExtra("cake");
        image.setImageResource(cake.getImage());
        name.setText(cake.getName());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void mapping() {
        btnBack=findViewById(R.id.btnback);
        name=findViewById(R.id.name1);
        image=findViewById(R.id.image1);
    }
}