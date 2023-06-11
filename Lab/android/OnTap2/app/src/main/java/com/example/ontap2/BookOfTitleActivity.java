package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookOfTitleActivity extends AppCompatActivity {

    RecyclerView rcbook;
    ArrayList<Book> lstBook;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_of_title);
        setControl();
        loadBook();
    }

    private void loadBook() {
        loadData();
        bookAdapter=new BookAdapter(this,lstBook,R.layout.item_book);
        rcbook.setAdapter(bookAdapter);
        rcbook.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void loadData() {
        lstBook=new ArrayList<>();
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.urlBookOfTitle + "?mcd=" + getIntent().getStringExtra("code"), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        lstBook.add(new Book(jsonObject.getString("code"),jsonObject.getString("name"),jsonObject.getDouble("price"),jsonObject.getString("image"),jsonObject.getString("description")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bookAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }

    private void setControl() {
        rcbook = findViewById(R.id.rcbookoftitle);
    }
}