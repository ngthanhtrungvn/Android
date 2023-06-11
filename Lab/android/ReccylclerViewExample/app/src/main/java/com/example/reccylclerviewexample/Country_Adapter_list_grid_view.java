package com.example.reccylclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Country_Adapter_list_grid_view extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Country> lstCountry;

    public Country_Adapter_list_grid_view(Context context, int layout, ArrayList<Country> lstCountry) {
        this.context = context;
        this.layout = layout;
        this.lstCountry = lstCountry;
    }

    @Override
    public int getCount() {
        return lstCountry.size();
    }

    @Override
    public Object getItem(int i) {
        return lstCountry.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view= LayoutInflater.from(context).inflate(layout,null);
        ImageView imgFlag=view.findViewById(R.id.flag);
        TextView txtName=view.findViewById(R.id.txtName);
        TextView txtPopulation=view.findViewById(R.id.txtPopulation);
        Country country=lstCountry.get(i);
        imgFlag.setImageResource(country.getFlag());
        txtName.setText(country.getName());
        txtPopulation.setText(country.getPopulation());

        return view;
    }
}
