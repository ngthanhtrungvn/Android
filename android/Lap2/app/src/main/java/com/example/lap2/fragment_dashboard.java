package com.example.lap2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragment_dashboard extends Fragment {
    Context context;
    ArrayList<Dashboard> lstDashboard;
    GridView gridView;
    public fragment_dashboard(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        DashboardAdapter adapter=new DashboardAdapter(context,R.layout.item_dashboard,lstDashboard);
        gridView.setAdapter(adapter);
    }

    private void mapping(View view) {
        gridView=view.findViewById(R.id.gridView);
        lstDashboard=new ArrayList<>();
        lstDashboard.add(new Dashboard(R.drawable.diningroom,"Diningroom"));
        lstDashboard.add(new Dashboard(R.drawable.livingroom,"Livingroom"));
        lstDashboard.add(new Dashboard(R.drawable.bedroom,"Bedroom"));
        lstDashboard.add(new Dashboard(R.drawable.accessories,"Accessories"));
    }
}
