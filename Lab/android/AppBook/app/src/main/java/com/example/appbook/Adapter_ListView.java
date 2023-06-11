package com.example.appbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_ListView extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<item_lv> listItem;

    public Adapter_ListView(Context context, int layout, ArrayList<item_lv> listItem) {
        this.context=context;
        this.layout=layout;
        this.listItem=listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view= LayoutInflater.from(context).inflate(layout,null);
        item_lv item=listItem.get(i);
        ImageView imageView=view.findViewById(R.id.image_listview);
        TextView textView=view.findViewById(R.id.text_listview);
        imageView.setImageResource(item.getImage());
        textView.setText(item.getText());
        return view;
    }
}
