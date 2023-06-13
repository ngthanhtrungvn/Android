package com.example.tuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom);
        loadFragment(new fragment_home());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id)
                {
                    case R.id.mnuHome:
                        loadFragment(new fragment_home());
                        break;
                    case R.id.mnuDashboard:
                        loadFragment(new fragment_Dashboard());
                        break;
                    case R.id.mnuNotification:
                        loadFragment(new fragment_notification());
                        break;
                    case R.id.mnuFriend:
                        break;
                }
                return true;
            }
        });
    }
    public void loadFragment(Fragment f)
    {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main,f);
        fragmentTransaction.commit();
    }
}