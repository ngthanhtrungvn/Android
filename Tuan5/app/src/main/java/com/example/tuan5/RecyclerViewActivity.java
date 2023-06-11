package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.github.javafaker.Faker;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvDemo = findViewById(R.id.rv_demo);
        rvDemo.setLayoutManager(new LinearLayoutManager(this));

        Faker faker = new Faker();
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            contacts.add(new Contact(faker.name().fullName(), faker.phoneNumber().cellPhone()));
        }
        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(this, contacts);

//        contacts.add(new Contact("Alison","16506462742"));
//        contacts.add(new Contact("James","16506462742"));
//        contacts.add(new Contact("Cameron","16506462742"));
//        contacts.add(new Contact("James","16506462742"));
//        contacts.add(new Contact("Cameron","16506462742"));
//        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(this, contacts);
        rvDemo.setAdapter(adapter);
        rvDemo.setItemAnimator(new FadeInAnimator());
    }
}