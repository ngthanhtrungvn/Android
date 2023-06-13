package com.example.duongdongduy_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setControl();
        loadData();
    }

    private void loadData() {
        Product product= (Product) getIntent().getSerializableExtra("product");
        Picasso.get().load(Server.urlImage+product.image).into(imageView);
        name.setText(product.getName());
        price.setText(product.getPrice());
    }

    private void setControl() {
        imageView=findViewById(R.id.image_detail);
        name=findViewById(R.id.name_detail);
        price=findViewById(R.id.price_detail);
    }
}