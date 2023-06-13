package com.example.truyencuoi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.truyencuoi2.databinding.ItemBinding;

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
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

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
        ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
