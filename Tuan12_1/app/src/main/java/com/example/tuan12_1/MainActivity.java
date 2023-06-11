package com.example.tuan12_1;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tuan12_1.databinding.ActivityMainBinding;
import com.example.tuan12_1.databinding.FragmentItemListBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReplaceFragment();
    }



    public void ReplaceFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(
                binding.info.getId(),
                InformationEmployeeFragment.newInstance(adapter)
        );
        transaction.replace(
                binding.list.getId(),
                ItemFragment.newInstance(adapter)
        );
        transaction.commit();
    }
}