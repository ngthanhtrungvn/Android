package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDemo;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDemo = findViewById(R.id.lv_demo);
        btnAdd = findViewById(R.id.btn_add);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alison","16506462742"));
        contacts.add(new Contact("James","16506462742"));
        contacts.add(new Contact("Cameron","16506462742"));

        ContactListAdapter adapter = new ContactListAdapter(this, contacts);
        lvDemo.setAdapter(adapter);


       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adapter.add(new Contact("das","123456789"));
           }
       });

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//        lvDemo.setAdapter(adapter);
//
//        adapter.add("Ha Noi");
//        adapter.add("TPHCM");
//        adapter.add("Hai phong");
//
//        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String data = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}