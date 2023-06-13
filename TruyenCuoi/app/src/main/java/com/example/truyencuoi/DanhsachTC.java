package com.example.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.truyencuoi.databinding.ActivityDanhsachTcBinding;

public class DanhsachTC extends AppCompatActivity {
    ActivityDanhsachTcBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDanhsachTcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}