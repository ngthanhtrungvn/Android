package com.example.duongdongduy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Cake> lstCakes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        initialize();

        CakeAdapter adapter=new CakeAdapter(this,R.layout.item,lstCakes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void initialize() {
        lstCakes=new ArrayList<>();
        lstCakes.add(new Cake("Cakes","44 items",R.drawable.cakes));
        lstCakes.add(new Cake("Foods","12 items",R.drawable.food));
        lstCakes.add(new Cake("Fruits","78 items",R.drawable.fruit));
        lstCakes.add(new Cake("Sweeties","98 items",R.drawable.sweeties));
        lstCakes.add(new Cake("Vegetables","9 items",R.drawable.vegetables));
        lstCakes.add(new Cake("Cakes","44 items",R.drawable.cakes));
        lstCakes.add(new Cake("Foods","12 items",R.drawable.food));
        lstCakes.add(new Cake("Fruits","78 items",R.drawable.fruit));
        lstCakes.add(new Cake("Sweeties","98 items",R.drawable.sweeties));
        lstCakes.add(new Cake("Vegetables","9 items",R.drawable.vegetables));
        lstCakes.add(new Cake("Cakes","44 items",R.drawable.cakes));
        lstCakes.add(new Cake("Foods","12 items",R.drawable.food));
        lstCakes.add(new Cake("Fruits","78 items",R.drawable.fruit));
        lstCakes.add(new Cake("Sweeties","98 items",R.drawable.sweeties));
        lstCakes.add(new Cake("Vegetables","9 items",R.drawable.vegetables));
        lstCakes.add(new Cake("Cakes","44 items",R.drawable.cakes));
        lstCakes.add(new Cake("Foods","12 items",R.drawable.food));
        lstCakes.add(new Cake("Fruits","78 items",R.drawable.fruit));
        lstCakes.add(new Cake("Sweeties","98 items",R.drawable.sweeties));
        lstCakes.add(new Cake("Vegetables","9 items",R.drawable.vegetables));

    }

    private void mapping() {
        recyclerView=findViewById(R.id.recylclerview);
    }
}