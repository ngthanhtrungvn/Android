package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment_notification extends Fragment {
    ArrayList<Room> lstRoom;
    RecyclerView recyclerView;
    Context context;

    public fragment_notification(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notification, container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        RoomAdapter adapter=new RoomAdapter(context,R.layout.item,lstRoom);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
    }

    private void mapping(View view) {
        recyclerView=view.findViewById(R.id.recylclerview_notification);
        lstRoom=new ArrayList<>();
        lstRoom.add(new Room(R.drawable.livingroom,"Livingroom","Day la mo ta livingrom"));
        lstRoom.add(new Room(R.drawable.bedroom,"Bedroom","Day la mo ta Bedroom"));
        lstRoom.add(new Room(R.drawable.diningroom,"Diningroom","Day la mo ta Diningroom"));
    }
}
