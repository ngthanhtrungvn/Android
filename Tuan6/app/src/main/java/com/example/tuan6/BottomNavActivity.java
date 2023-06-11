package com.example.tuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        bottomNavView = findViewById(R.id.bottom_nav_menu);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_scanner:
                        replaceFragment(DetailDemoFragment.newInstance("Scanner"));
                        return true;
                    case R.id.file:
                        replaceFragment(DetailDemoFragment.newInstance("File"));

                        return true;
                    case R.id.email:
                        replaceFragment(DetailDemoFragment.newInstance("Email"));

                        return true;
                }

                return false;
            }
        });
    }

    private void replaceFragment(Fragment r) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_detail_position, r);
        transaction.commit();


    }
}