package com.example.appbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BookOfTitle extends AppCompatActivity {

    TextView txt;
    String machude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_of_title);
        txt = findViewById(R.id.bookoftitle_title);
        Intent intent = getIntent();
        machude = intent.getStringExtra("machude");
        LoadBookOfTitle();
    }

    public void LoadBookOfTitle() {
        //127.0.0.1
        String url = Server.urlBookOfTitle+"?mcd="+machude;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String text = "";

                for (int i = 0; i < response.length(); i++) {
                    Log.d("duy", "onResponse: "+text);
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        text += jsonObject.getString("tensach");

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "loi" + e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
                txt.setText(text);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "loi" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);

    }

}