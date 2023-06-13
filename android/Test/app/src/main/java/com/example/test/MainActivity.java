package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> lstBook;
    RecyclerView recyclerView;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        lstBook=new ArrayList<>();
        lstBook.add(new Book(R.drawable.vietnam,"s1","Viet nam","day la sach viet nam",12400));
        lstBook.add(new Book(R.drawable.singapore,"s2","Singapore","day la sach singapore",450998));
        lstBook.add(new Book(R.drawable.argentina,"s3","Argentina","day la sach Argentina",12345));
        lstBook.add(new Book(R.drawable.usa,"s4","Mỹ Tho","day la sach mỹ tho",98753));
        BookAdapter adapter=new BookAdapter(this,R.layout.item,lstBook);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PayActivity.class);
                intent.putExtra("lstbook",lstBook);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        recyclerView=findViewById(R.id.recyclerView);
        btnConfirm=findViewById(R.id.btnconfirm);
    }
}