package com.example.tuan5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Contact> items;

    public ContactListAdapter(Context context, ArrayList<Contact> items) {
        this.context = context;
        this.items = items;
    }
    public void add(Contact contact) {
        items.add(contact);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.activity_contact, null);
        TextView tvName = layout.findViewById(R.id.tv_name);
        tvName.setText(items.get(i).getName());

        TextView tvPhone = layout.findViewById(R.id.tv_phone);
        tvPhone.setText(items.get(i).getPhone());
        return layout;
    }
}
