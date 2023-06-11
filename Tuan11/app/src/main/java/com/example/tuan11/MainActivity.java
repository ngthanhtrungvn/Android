package com.example.tuan11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.tuan11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

//        binding.txtview.setText("Xin chao");

//        replaceFragment();
//
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
//        binding.recyclerViewDemo.setAdapter(adapter);
//        binding.recyclerViewDemo.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//        adapter.add("1");
//        adapter.add("2");
//        adapter.add("3");
//        adapter.add("4");

        ExampleViewModel vm = new ExampleViewModel();
        vm.setDemoText("Day la data binding");

        binding.setM(vm);

    }

    public void replaceFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(
                binding.contentFragment.getId(),
                BlankFragment.newInstance()
        );
        transaction.commit();
    }
}