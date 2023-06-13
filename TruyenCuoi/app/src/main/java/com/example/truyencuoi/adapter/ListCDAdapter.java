package com.example.truyencuoi.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.truyencuoi.DanhsachCD;
import com.example.truyencuoi.EditCD;
import com.example.truyencuoi.MainActivity;
import com.example.truyencuoi.databinding.ListItemCdBinding;
import com.example.truyencuoi.helper.dpHelper_Topic;
import com.example.truyencuoi.model.topics;

import java.util.ArrayList;

public class ListCDAdapter extends RecyclerView.Adapter<ListCDAdapter.ViewHolder> {
    ArrayList<topics> chude;
    Context context;


    public ListCDAdapter(Context context, ArrayList<topics> chude) {

        this.context = context;

        this.chude = chude;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemCdBinding binding = ListItemCdBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.tvID.setText(chude.get(position).getId()+"");
        holder.binding.tvTenCD.setText(chude.get(position).getName());
        holder.binding.imageView2.setImageBitmap(chude.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return chude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemCdBinding binding;

        public ViewHolder(ListItemCdBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(
                            context, EditCD.class
                    );
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("posision",chude.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
            binding.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dpHelper_Topic db = new dpHelper_Topic(context);

                    db.deleteTopic(chude.get(getAdapterPosition()).getId());
                    Toast.makeText(context, "Xóa thành công.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(
                            context, DanhsachCD.class
                    );
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
