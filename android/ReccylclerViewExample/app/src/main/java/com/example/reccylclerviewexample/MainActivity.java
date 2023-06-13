package com.example.reccylclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Country> lstCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        contructor();
        Country_Adapter_Recyclerview adapter_recyclerview=new Country_Adapter_Recyclerview(this,R.layout.item_recylclerview,lstCountry);
        recyclerView.setAdapter(adapter_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void contructor() {
        lstCountry=new ArrayList<>();
        lstCountry.add(new Country(R.drawable.vietnam,"Việt Nam","100.000.000"));
        lstCountry.add(new Country(R.drawable.singapore,"Singapore","10.000.000"));
        lstCountry.add(new Country(R.drawable.argentina,"Argentina","45.500.000"));
        lstCountry.add(new Country(R.drawable.brazil,"Brazil","2.000.000"));
        lstCountry.add(new Country(R.drawable.cambodia,"Campuchia","55.000.000"));
        lstCountry.add(new Country(R.drawable.usa,"Mỹ Tho","400.000.000"));
    }


    private void mapping() {
        recyclerView=findViewById(R.id.recycleview);

    }
}