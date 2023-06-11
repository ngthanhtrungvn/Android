package com.example.tuan5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<Contact> items;

    public ContactRecyclerAdapter(Context context, ArrayList<Contact> items) {
        this.context = context;
        this.items = items;
    }

    public void removeAt(int i) {
        items.remove(i);
//        notifyDataSetChanged();
        notifyItemRemoved(i);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.activity_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = items.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName, tvPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            Contact contact = items.get(getAdapterPosition());

            Toast.makeText(context, contact.getName(), Toast.LENGTH_SHORT).show();
            removeAt(getAdapterPosition());
//            getAdapterPosition();
        }
    }
}
