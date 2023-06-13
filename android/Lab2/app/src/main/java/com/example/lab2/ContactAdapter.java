package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewContact> {

    Context context;
    int layout;
    ArrayList<Contact> arrayList;

    public ContactAdapter(Context context, int layout, ArrayList<Contact> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewContact(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewContact holder, int position) {
        Contact contact = arrayList.get(position);
        holder.nameContact.setText(contact.getName());
        holder.phoneContact.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewContact extends RecyclerView.ViewHolder {

        ImageView imageContact;
        TextView nameContact, phoneContact;

        public ViewContact(@NonNull View itemView) {
            super(itemView);
            imageContact = itemView.findViewById(R.id.imageContact);
            nameContact = itemView.findViewById(R.id.nameContact);
            phoneContact = itemView.findViewById(R.id.phoneContact);
        }
    }
}
