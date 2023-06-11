package com.example.tuan12_1;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tuan12_1.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.tuan12_1.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {


    ArrayList<NhanVien> nhanViens = new ArrayList<>();



    public void add(String maNV, String tenNV, Boolean sex){
        NhanVien nv = new NhanVien(maNV, tenNV, sex);
        nhanViens.add(nv);
        notifyDataSetChanged();
    }

    public void delete(){
        nhanViens.removeIf(s -> (s.getDelete() == true));
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentItemBinding binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);

    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(nhanViens.get(position).getSex())
            holder.binding.icon.setBackgroundResource(R.drawable.baseline_boy_24);
        else holder.binding.icon.setBackgroundResource(R.drawable.baseline_girl_24);
        holder.binding.itemId.setText(nhanViens.get(position).getMaNV());
        holder.binding.itemContent.setText(nhanViens.get(position).getTenNV());
        holder.binding.ckb.setChecked(nhanViens.get(position).getDelete());
    }



    @Override
    public int getItemCount() {
        return nhanViens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FragmentItemBinding binding;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.ckb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nhanViens.get(getAbsoluteAdapterPosition()).setDelete(binding.ckb.isChecked());
                }
            });

        }
    }
}