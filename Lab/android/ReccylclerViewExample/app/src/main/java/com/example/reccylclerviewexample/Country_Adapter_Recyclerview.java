package com.example.reccylclerviewexample;

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

public class Country_Adapter_Recyclerview extends RecyclerView.Adapter<_View> {

    Context context;
    int layout;
    ArrayList<Country> lstCountry;

    public Country_Adapter_Recyclerview(Context context, int layout, ArrayList<Country> lstCountry) {
        this.context = context;
        this.layout = layout;
        this.lstCountry = lstCountry;
    }

    @NonNull
    @Override
    public _View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View holder, int position) {
        Country country = lstCountry.get(position);
        holder.imgFlag.setImageResource(country.getFlag());
        holder.txtName.setText(country.getName());
        holder.txtPopulation.setText(country.getPopulation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemLoadActivity.class);
                intent.putExtra("country", country);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstCountry.size();
    }
}

class _View extends RecyclerView.ViewHolder {

    ImageView imgFlag;
    TextView txtName, txtPopulation;

    public _View(@NonNull View itemView) {
        super(itemView);
        imgFlag = itemView.findViewById(R.id.flag);
        txtName = itemView.findViewById(R.id.txtName);
        txtPopulation = itemView.findViewById(R.id.txtPopulation);
    }
}
