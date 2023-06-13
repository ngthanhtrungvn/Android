package com.example.ontap2;

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

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewBook> {
       Context context;
       ArrayList<Book> lstBook;
       int layout;

        public BookAdapter(Context context, ArrayList<Book> lstBook, int layout) {
            this.context = context;
            this.lstBook = lstBook;
            this.layout = layout;
        }

    @NonNull
    @Override
    public ViewBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewBook(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewBook holder, int position) {
        Book book=lstBook.get(position);
        holder.name.setText(book.getName());
        holder.price.setText(book.getPrice()+"");
        Picasso.get().load(Server.urlImage+book.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,BookDetail.class);
                intent.putExtra("book",book);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstBook.size();
    }

    public static class ViewBook extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        public ViewBook(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_book);
            name = itemView.findViewById(R.id.name_book);
            price = itemView.findViewById(R.id.price_book);
        }
    }
}
