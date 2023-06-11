package com.example.listfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Fruit> listFruit;

    public FruitAdapter(Context context, int layout, ArrayList<Fruit> listFruit) {
        this.context = context;
        this.layout = layout;
        this.listFruit = listFruit;
    }

    public FruitAdapter() {

    }

    @Override
    public int getCount() {
        return listFruit.size();
    }

    @Override
    public Object getItem(int i) {
        return listFruit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView txtName, txtDescription;
        ImageView imgFruit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
            viewHolder.txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            viewHolder.imgFruit = (ImageView) view.findViewById(R.id.imgFruit);
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();
        Fruit fruit = (Fruit) getItem(i);
        viewHolder.txtName.setText(fruit.name);
        viewHolder.txtDescription.setText(fruit.description);
        viewHolder.imgFruit.setImageResource(fruit.image);
        return view;
    }
}
