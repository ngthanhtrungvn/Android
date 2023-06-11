package com.example.firebase.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firebase.R;
import com.example.firebase.fragment.FragmentCart;
import com.example.firebase.fragment.FragmentHome;
import com.example.firebase.fragment.LoginSignupFragment;
import com.example.firebase.fragment.LoginTabFragment;
import com.example.firebase.fragment.SignupTabFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        fm = new FragmentHome(this);
        loadFragment(fm);
        setOnClickBottomView();
    }

    private void setOnClickBottomView() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.mn_home:
                        fm = new FragmentHome(getApplicationContext());
                        break;
                    case R.id.mn_cart:
                        fm=new FragmentCart(getApplicationContext());
                        break;
                    case R.id.mn_account:
                        fm=new LoginSignupFragment(getApplicationContext());
                        break;
                    default:
                        fm = new FragmentHome(getApplicationContext());
                }
                loadFragment(fm);
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framehost, fragment);
        fragmentTransaction.commit();
    }

    private void setControl() {
        bottomNavigationView = findViewById(R.id.bottomnavigation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }
}
