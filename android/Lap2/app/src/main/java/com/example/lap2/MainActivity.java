package com.example.lap2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        fm = new fragment_home(this);
        loadFragment(fm);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.mnuhome:
                        fm = new fragment_home(getApplicationContext());
                        break;
                    case R.id.mnudashboard:
                        fm = new fragment_dashboard(getApplicationContext());
                        break;
                    case R.id.mnunotification:
                        fm = new fragment_notification(getApplicationContext());
                        break;
                    case R.id.mnufriend:
                        break;
                    default:
                        break;
                }
                loadFragment(fm);
                return true;
            }
        });
    }
    private void mapping() {
        bottomNavigationView = findViewById(R.id.navigation_bottom);
    }
    private void loadFragment(Fragment f) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, f);
        fragmentTransaction.commit();
    }
}