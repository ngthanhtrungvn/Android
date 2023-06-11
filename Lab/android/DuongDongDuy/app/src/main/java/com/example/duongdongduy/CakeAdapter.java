package com.example.duongdongduy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CakeAdapter extends RecyclerView.Adapter<_View> {
    Context context;
    int layout;
    ArrayList<Cake> lstCakes;

    public CakeAdapter(Context context, int layout, ArrayList<Cake> lstCakes) {
        this.context = context;
        this.layout = layout;
        this.lstCakes = lstCakes;
    }

    @NonNull
    @Override
    public _View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View holder, int position) {
        Cake cake = lstCakes.get(position);
        holder.image.setImageResource(cake.getImage());
        holder.name.setText(cake.getName());
        holder.quantity.setText(cake.getQuantity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ItemLoadActivity.class);
                intent.putExtra("cake",cake);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstCakes.size();
    }
}

class _View extends RecyclerView.ViewHolder {
    TextView name, quantity;
    ImageView image;

    public _View(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        quantity = itemView.findViewById(R.id.quantity);
        image = itemView.findViewById(R.id.image);
    }
}
