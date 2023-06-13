package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PayActivity extends AppCompatActivity {

    ArrayList<Book> lstBook;
    RecyclerView recyclerView;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        mapping();
        Intent intent=getIntent();
        lstBook= (ArrayList<Book>) intent.getSerializableExtra("lstbook");
        ArrayList<Book> lstBook1=new ArrayList<>();
        double _total=0;

        for(Book item:lstBook)
        {
            if(item.isStatus())
            {
                lstBook1.add(item);
                _total+=item.price;
            }
        }

        BookAdapter1 adapter=new BookAdapter1(this,R.layout.item1,lstBook1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        total.setText("Tổng tiền:"+_total);
    }

    private void mapping() {
        recyclerView=findViewById(R.id.recyclerView1);
        total=findViewById(R.id.total);
    }
}