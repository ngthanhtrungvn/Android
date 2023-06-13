package com.example.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.truyencuoi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SQLiteDatabase db = openOrCreateDatabase("truyencuoi_sqlite.db", MODE_PRIVATE, null);
        String sql = "create table if not exists tblTopics(id integer PRIMARY KEY autoincrement, name text, image blob);";
        sql +=       "create table if not exists tblStories(id integer PRIMARY KEY autoincrement, id_topic integer, title text, content text);";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnTCD:
                intent = new Intent(MainActivity.this, ThemCD.class);
                startActivity(intent);
                break;
            case R.id.btnDSCD:
                intent = new Intent(MainActivity.this, DanhsachCD.class);
                startActivity(intent);
                break;
        }
    }
}