package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter1 extends RecyclerView.Adapter<_View1> {
    Context context;
    int layout;
    ArrayList<Book> lstBook;

    public BookAdapter1(Context context, int layout, ArrayList<Book> lstBook) {
        this.context = context;
        this.layout = layout;
        this.lstBook = lstBook;
    }

    @NonNull
    @Override
    public _View1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View1(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View1 holder, int position) {
        int index=position;
        Book book = lstBook.get(index);
        holder.imgbook.setImageResource(book.getImgBook());
        holder.name.setText(book.getName());
        holder.price.setText(book.getPrice() + "");
        holder.description.setText(book.getDescription());
        holder.code.setText(book.getCode());
    }

    @Override
    public int getItemCount() {
        return lstBook.size();
    }
}

class _View1 extends RecyclerView.ViewHolder{
    ImageView imgbook;
    TextView name, price, description, code;

    public _View1(@NonNull View itemView) {
        super(itemView);
        imgbook = itemView.findViewById(R.id.imgbook1);
        name = itemView.findViewById(R.id.namebook1);
        price = itemView.findViewById(R.id.price1);
        description = itemView.findViewById(R.id.description1);
        code = itemView.findViewById(R.id.codebook1);
    }
}
