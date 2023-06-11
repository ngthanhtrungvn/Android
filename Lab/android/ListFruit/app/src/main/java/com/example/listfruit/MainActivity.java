package com.example.listfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FruitAdapter adapter;
    ListView listView;
    ArrayList<Fruit> fruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
       adapter=new FruitAdapter(this,R.layout.row_fruit,fruits);
     listView.setAdapter(adapter);
    }
    void mapping()
    {
        listView=(ListView) findViewById(R.id.listViewFruit);
        fruits=new ArrayList<>();
        fruits.add(new Fruit("Dâu tây", "Đặc sản Đà Lạt",R.drawable.strawberry));
        fruits.add(new Fruit("Cam", "Đặc sản Cà Mau",R.drawable.orange));
        fruits.add(new Fruit("Chuối", "Đặc sản Tiền Giang",R.drawable.banana));
        fruits.add(new Fruit("Dâu tây", "Đặc sản Đà Lạt",R.drawable.strawberry));
        fruits.add(new Fruit("Cam", "Đặc sản Cà Mau",R.drawable.orange));
        fruits.add(new Fruit("Chuối", "Đặc sản Tiền Giang",R.drawable.banana));
        fruits.add(new Fruit("Dâu tây", "Đặc sản Đà Lạt",R.drawable.strawberry));
        fruits.add(new Fruit("Cam", "Đặc sản Cà Mau",R.drawable.orange));
        fruits.add(new Fruit("Chuối", "Đặc sản Tiền Giang",R.drawable.banana));

    }
}