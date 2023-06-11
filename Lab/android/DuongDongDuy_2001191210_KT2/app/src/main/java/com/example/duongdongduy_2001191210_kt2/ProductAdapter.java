package com.example.duongdongduy_2001191210_kt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewProduct> {
   Context context;
   ArrayList<Product> lstProduct;
   int layout;

    public ProductAdapter(Context context, ArrayList<Product> lstProduct, int layout) {
        this.context = context;
        this.lstProduct = lstProduct;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewProduct(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewProduct holder, int position) {
        Product product=lstProduct.get(position);
        Picasso.get().load(Server.urlImage+product.getImage()).into(holder.image);
        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return lstProduct.size();
    }

    public static class ViewProduct extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,price;
        public ViewProduct(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_product);
            name=itemView.findViewById(R.id.name_product);
            price=itemView.findViewById(R.id.price_product);
        }
    }
}