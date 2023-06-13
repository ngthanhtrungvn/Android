package com.example.reccylclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> lstCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mapping();
        contructor();
        Country_Adapter_list_grid_view adapter = new Country_Adapter_list_grid_view(this, R.layout.item_recylclerview, lstCountry);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = lstCountry.get(i);
                Intent intent = new Intent(ListViewActivity.this, ItemLoadActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });
    }

    private void contructor() {
        lstCountry = new ArrayList<>();
        lstCountry.add(new Country(R.drawable.vietnam, "Việt Nam", "100.000.000"));
        lstCountry.add(new Country(R.drawable.singapore, "Singapore", "10.000.000"));
        lstCountry.add(new Country(R.drawable.argentina, "Argentina", "45.500.000"));
        lstCountry.add(new Country(R.drawable.brazil, "Brazil", "2.000.000"));
        lstCountry.add(new Country(R.drawable.cambodia, "Campuchia", "55.000.000"));
        lstCountry.add(new Country(R.drawable.usa, "Mỹ Tho", "400.000.000"));

    }

    private void mapping() {
        listView = findViewById(R.id.listview);
    }
}