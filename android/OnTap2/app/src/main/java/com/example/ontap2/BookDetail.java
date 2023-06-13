package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetail extends AppCompatActivity {

    ImageView image;
    TextView name,price,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        setControl();
        loadData();
    }

    private void loadData() {
        Book book= (Book) getIntent().getSerializableExtra("book");
        Picasso.get().load(Server.urlImage+book.getImage()).into(image);
        name.setText(book.getName());
        price.setText(book.getPrice()+"");
        description.setText(book.getDescription());
    }

    private void setControl() {
        image=findViewById(R.id.image_book_detail);
        name=findViewById(R.id.name_book_detail);
        price=findViewById(R.id.price_book_detail);
        description=findViewById(R.id.description_detail);
    }
}