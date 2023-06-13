package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.Room;

import java.util.ArrayList;
import java.util.Locale;

public class RoomAdapter extends RecyclerView.Adapter<_View> implements Filterable {
    Context context;
    int layout;
    ArrayList<Room> lstRoom;
    ArrayList<Room> lstFull;

    public RoomAdapter(Context context, int layout, ArrayList<Room> lstRoom) {
        this.context = context;
        this.layout = layout;
        this.lstRoom = lstRoom;
        this.lstFull=this.lstRoom;
    }

    @NonNull
    @Override
    public _View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View holder, int position) {
        int index=position;
        Room room=lstRoom.get(index);
        holder.image.setImageResource(room.getImage());
        holder.name.setText(room.getName());
        holder.description.setText(room.getDescription());
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.zoomin));
    }

    @Override
    public int getItemCount() {
        return lstRoom.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                ArrayList<Room> lstTemp=new ArrayList<>();
                String keyword=charSequence.toString().toLowerCase();
                if(keyword==null||keyword.equals(""))
                    lstTemp=lstFull;
                else
                {
                    for(Room room:lstFull)
                        if(room.getName().toLowerCase().startsWith(keyword)||room.getDescription().toLowerCase().startsWith(keyword))
                            lstTemp.add(room);
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=lstTemp;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                lstRoom= (ArrayList<Room>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
class _View extends RecyclerView.ViewHolder{

    ImageView image;
    TextView name,description;
    public _View(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.image);
        name=itemView.findViewById(R.id.name);
        description=itemView.findViewById(R.id.description);
    }
}
