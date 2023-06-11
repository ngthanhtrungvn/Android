package com.example.tuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.demo_toolbar);
//        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Hello Title");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.draw_layout_demo);
        navigationView = findViewById(R.id.nav_view_demo);
        drawerLayout.openDrawer(GravityCompat.START);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_scanner:
                        Toast.makeText(MainActivity.this, "Click Scanner", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.file:
                        Toast.makeText(MainActivity.this, "Click file", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.email:
                        Toast.makeText(MainActivity.this, "Click email", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_scanner:
                Toast.makeText(this, "Click Scanner", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.file:
                Toast.makeText(this, "Click file", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.email:
                Toast.makeText(this, "Click email", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}