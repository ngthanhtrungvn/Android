package com.example.ontapkiemtralan2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleView> {
    private Context context;
    private ArrayList<Title> lstTitle;
    private int layout;

    public TitleAdapter(Context context, ArrayList<Title> lstTitle, int layout) {
        this.context = context;
        this.lstTitle = lstTitle;
        this.layout = layout;
    }

    @NonNull
    @Override
    public TitleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TitleView(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull TitleView holder, int position) {
        Title title = lstTitle.get(position);
        holder.name.setText(title.getName());
        Picasso.get().load(Server.urlImage + title.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Book> lstBook = new ArrayList<>();
                RequestQueue queue = Volley.newRequestQueue(context);
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.urlGetBookOfTitle + "?mcd=" + title.getCode(), new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                lstBook.add(new Book(jsonObject.getString("code"), jsonObject.getString("name"), jsonObject.getDouble("price"), jsonObject.getString("description"), jsonObject.getString("image")));
                                Log.d("duy", "onResponse: " + jsonObject.getString("name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Intent intent = new Intent(context, BookOfTitle.class);
                        intent.putExtra("lstBook", lstBook);
                        context.startActivity(intent);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Loi:" + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(jsonArrayRequest);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lstTitle.size();
    }

    public static class TitleView extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public TitleView(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_title);
            name = itemView.findViewById(R.id.text_title);
        }
    }
}
