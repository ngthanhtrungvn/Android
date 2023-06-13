package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DashboardAdapter extends BaseAdapter {

    Context context;
    ArrayList<Dashboard> lstDashboard;
    int layout;

    public DashboardAdapter(Context context, int layout, ArrayList<Dashboard> lstDashboard) {
        this.context = context;
        this.lstDashboard = lstDashboard;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return lstDashboard.size();
    }

    @Override
    public Object getItem(int i) {
        return lstDashboard.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(layout, null);
        ImageView imageView;
        TextView textView;
        imageView = view.findViewById(R.id.imageDashboard);
        textView = view.findViewById(R.id.txtNameDashboard);
        Dashboard dashboard = lstDashboard.get(i);
        imageView.setImageResource(dashboard.getImage());
        textView.setText(dashboard.getName());
        return view;
    }
}
