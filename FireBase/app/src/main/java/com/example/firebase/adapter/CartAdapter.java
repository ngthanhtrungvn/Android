package com.example.firebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase.R;
import com.example.firebase.model.Cart;
import com.example.firebase.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    int layout;
    ArrayList<Cart> lstCart;

    public CartAdapter(Context context, int layout, ArrayList<Cart> lstCart) {
        this.context = context;
        this.layout = layout;
        this.lstCart = lstCart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = lstCart.get(position);
        holder.image.setImageResource(cart.getImage());
        holder.quantity.setText(cart.getQuantity());
        holder.subtotal.setText(cart.getSubtoal());
        holder.price.setText(cart.getPrice());
        holder.name.setText(cart.getName());
    }

    @Override
    public int getItemCount() {
        return lstCart.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, price, subtotal;
        EditText quantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_detail_cart);
            name = itemView.findViewById(R.id.name_detail_cart);
            price = itemView.findViewById(R.id.price_deatail_cart);
            subtotal = itemView.findViewById(R.id.subtotal_detail_cart);
            quantity = itemView.findViewById(R.id.quantity_detail_cart);
        }
    }
}
