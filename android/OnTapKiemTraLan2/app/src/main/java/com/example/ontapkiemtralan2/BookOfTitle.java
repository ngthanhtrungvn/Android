package com.example.ontapkiemtralan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class BookOfTitle extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Book> lstBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_of_title);
        setControl();
        loadBook();
    }

    private void loadBook() {
        Intent intent=getIntent();
       lstBook= (ArrayList<Book>) intent.getSerializableExtra("lstBook");
        Log.d("duy", "loadBook: "+lstBook.size());
       BookAdapter bookAdapter=new BookAdapter(this,lstBook,R.layout.item_book);
       recyclerView.setAdapter(bookAdapter);
       recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void setControl() {
        recyclerView=findViewById(R.id.recycleview_book);
    }
}