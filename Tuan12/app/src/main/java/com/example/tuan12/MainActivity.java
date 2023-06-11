package com.example.tuan12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tuan12.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    NhietDoViewModel vm = new NhietDoViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setM(vm);
    }
}