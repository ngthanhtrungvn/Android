package com.example.test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<_View> {
    Context context;
    int layout;
    ArrayList<Book> lstBook;

    public BookAdapter(Context context, int layout, ArrayList<Book> lstBook) {
        this.context = context;
        this.layout = layout;
        this.lstBook = lstBook;
    }

    @NonNull
    @Override
    public _View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View holder, int position) {
        int index=position;
        Book book = lstBook.get(index);
        holder.imgbook.setImageResource(book.getImgBook());
        holder.name.setText(book.getName());
        holder.price.setText(book.getPrice() + "");
        holder.description.setText(book.getDescription());
        holder.code.setText(book.getCode());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    book.setStatus(true);
                else
                    book.setStatus(false);
                lstBook.set(index,book);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Hahaha",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstBook.size();
    }
}

class _View extends RecyclerView.ViewHolder {

    ImageView imgbook;
    TextView name, price, description, code;
    CheckBox checkBox;

    public _View(@NonNull View itemView) {
        super(itemView);
        imgbook = itemView.findViewById(R.id.imgbook);
        name = itemView.findViewById(R.id.namebook);
        price = itemView.findViewById(R.id.price);
        description = itemView.findViewById(R.id.description);
        code = itemView.findViewById(R.id.codebook);
        checkBox = itemView.findViewById(R.id.checkbox);
    }
}
