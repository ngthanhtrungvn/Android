package com.example.appbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerView_Adapter_Book extends RecyclerView.Adapter<_View_Book>{
    Context context;
    ArrayList<Book> listBook;
    int layout;

    public RecyclerView_Adapter_Book(Context context, ArrayList<Book> listBook, int layout) {
        this.context = context;
        this.listBook = listBook;
        this.layout = layout;
    }

    @NonNull
    @Override
    public _View_Book onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new _View_Book(LayoutInflater.from(context).inflate(layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull _View_Book holder, int position) {
        Book book= listBook.get(position);
        Picasso.get().load(Server.urlHinhAnh+book.getImage()).into(holder.image);
        holder.textName.setText(book.getText());
        holder.textPrice.setText(book.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }
}
class _View_Book extends RecyclerView.ViewHolder {

    ImageView image;
    TextView textName;
    TextView textPrice;
    public _View_Book(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.image_book);
        textName=itemView.findViewById(R.id.textname);
        textPrice=itemView.findViewById(R.id.textprice);
    }
}
