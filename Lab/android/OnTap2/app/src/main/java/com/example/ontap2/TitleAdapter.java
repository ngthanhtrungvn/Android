package com.example.ontap2;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewTitle> {

    Context context;
    ArrayList<Title> lstTitle;
    int layout;

    public TitleAdapter(Context context, ArrayList<Title> lstTitle, int layout) {
        this.context = context;
        this.lstTitle = lstTitle;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewTitle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewTitle(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTitle holder, int position) {
        Title title=lstTitle.get(position);
        holder.name.setText(title.getName());
        Picasso.get().load(Server.urlImage+title.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,BookOfTitleActivity.class);
                intent.putExtra("code",title.getCode());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstTitle.size();
    }

    public static class ViewTitle extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        public ViewTitle(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_title);
            name=itemView.findViewById(R.id.name_title);
        }
    }
}
