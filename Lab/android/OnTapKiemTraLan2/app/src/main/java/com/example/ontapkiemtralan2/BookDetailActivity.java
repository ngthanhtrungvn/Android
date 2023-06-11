package com.example.ontapkiemtralan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {

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
        Book book= (Book) getIntent().getSerializableExtra("bookdetail");
        Picasso.get().load(Server.urlImage+book.getImage()).into(image);
        price.setText(book.getPrice()+"");
        name.setText(book.getName());
        description.setText(book.getDescription());
    }

    private void setControl() {
        image=findViewById(R.id.image_book_detail);
        name=findViewById(R.id.text_book_detail);
        price=findViewById(R.id.price_book_detail);
        description=findViewById(R.id.description_book_detail);
    }
}