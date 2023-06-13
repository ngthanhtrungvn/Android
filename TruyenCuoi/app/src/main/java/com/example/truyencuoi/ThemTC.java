package com.example.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.truyencuoi.databinding.ActivityThemTcBinding;

public class ThemTC extends AppCompatActivity {
    ActivityThemTcBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemTcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}