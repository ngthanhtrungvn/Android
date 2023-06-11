package com.example.appbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewSlide_Adapter extends RecyclerView.Adapter<RecyclerViewSlide_Adapter._View> {
    Context context;
    ArrayList<ChuDe> lstSlide;
    int layout;

    public RecyclerViewSlide_Adapter(Context context, ArrayList<ChuDe> lstSlide, int layout) {
        this.context = context;
        this.lstSlide = lstSlide;
        this.layout = layout;
    }

    @NonNull
    @Override
    public _View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View holder, int position) {
        ChuDe chuDe = lstSlide.get(position);
        //hình để sau
        holder.textView.setText(chuDe.getTen());
        Picasso.get().load(Server.urlHinhAnh+chuDe.getHinh()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                texttitle
                Intent intent=new Intent(context,BookOfTitle.class);
                intent.putExtra("machude", chuDe.getMa());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstSlide.size();
    }

    public static class _View extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public _View(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_slide_recycler);
            textView = itemView.findViewById(R.id.textview_slide);
        }
    }
}

