package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewDemoActivity extends AppCompatActivity {

    GridView gvDemo;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        gvDemo = findViewById(R.id.gv_demo);
        btnAdd = findViewById(R.id.btn_add);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alison","16506462742"));
        contacts.add(new Contact("James","16506462742"));
        contacts.add(new Contact("Cameron","16506462742"));

        ContactListAdapter adapter = new ContactListAdapter(this, contacts);
        gvDemo.setAdapter(adapter);

        gvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(GridViewDemoActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(new Contact("das","123456789"));
            }
        });

    }
}