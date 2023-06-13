package com.example.choosebird;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> lstImg;
    ImageView imgRoot, imgChoose;
    private static final int REQUEST_CODE = 234;
    String nameRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        lstImg = Arrays.asList(getResources().getStringArray(R.array.lst_img_bird));
        setImgRoot();

    }

    private void setImgRoot() {
        //tron mang
        Collections.shuffle(lstImg);
        nameRoot = lstImg.get(4);
        int idImg = getResources().getIdentifier(nameRoot, "drawable", getPackageName());
        imgRoot.setImageResource(idImg);
        imgChoose.setImageResource(R.drawable.question);
    }


    public void OPENIMG(View v) {
        startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            imgChoose.setImageResource(getResources().getIdentifier(name, "drawable", getPackageName()));
            if(nameRoot.equals(name)) {
                Toast.makeText(this, "Đúng rồi!", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setImgRoot();
                    }
                },2000);
            }
            else
                Toast.makeText(this,"Sai rồi:((",Toast.LENGTH_SHORT).show();
        }
        if(requestCode==REQUEST_CODE && resultCode==RESULT_CANCELED)
            Toast.makeText(this, "Bạn chưa chọn hình:((", Toast.LENGTH_SHORT).show();

    }

    private void mapping() {
        imgRoot = findViewById(R.id.imgRoot);
        imgChoose = findViewById(R.id.imgChoose);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_reload:{
                setImgRoot();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }
}