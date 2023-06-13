package com.example.ontapkiemtralan2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookView> {
   private Context context;
    private ArrayList<Book> lstBook;
    private int layout;

    public BookAdapter(Context context, ArrayList<Book> lstBook, int layout) {
        this.context = context;
        this.lstBook = lstBook;
        this.layout = layout;
    }

    @NonNull
    @Override
    public BookView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookView(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull BookView holder, int position) {
        Book book =lstBook.get(position);
        Picasso.get().load(Server.urlImage+book.getImage()).into(holder.image);
        holder.name.setText(book.getName());
        holder.price.setText(book.getPrice()+"");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,BookDetailActivity.class);
                intent.putExtra("bookdetail",book);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstBook.size();
    }

    public static class BookView extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,price;
        public BookView(@NonNull View itemView) {
            super(itemView);
            name=  itemView.findViewById(R.id.text_book);
            price=  itemView.findViewById(R.id.price_book);
            image=  itemView.findViewById(R.id.image_book);
        }
    }
}
