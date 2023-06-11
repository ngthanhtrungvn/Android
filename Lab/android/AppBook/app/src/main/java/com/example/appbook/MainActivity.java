package com.example.appbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.KeyStore;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    RecyclerView recyclerView_slide, recyclerView_book;
    ArrayList<ChuDe> lstSlides = new ArrayList<>();
    ArrayList<Book> lstBook;
    ArrayList<item_lv> lstItemLV;
    ListView listView;
    RequestQueue requestQueue;
    RecyclerViewSlide_Adapter adapter_slide;
    ViewFlipper viewFlipper;
    RecyclerView_Adapter_Book adapterBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main);
        setControl();
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //set du lieu
        setSlide();

        setListBooks();

        setListView();
        loadSlideViewflipper();
    }

    private void setListView() {
        lstItemLV = new ArrayList<>();
        lstItemLV.add(new item_lv(R.drawable.ic_baseline_home_24, "Home"));
        lstItemLV.add(new item_lv(R.drawable.ic_baseline_info_24, "Info"));
        Adapter_ListView adapter_listView = new Adapter_ListView(this, R.layout.item_listview, lstItemLV);
        listView.setAdapter(adapter_listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.mnuhome:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnudashboard:
                Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void setListBooks() {
        lstBook = new ArrayList<>();
        loadSach();
        adapterBook = new RecyclerView_Adapter_Book(this, lstBook, R.layout.item_recycler_book);
        recyclerView_book.setAdapter(adapterBook);
        recyclerView_book.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void loadSach() {
        String url = Server.urlSach;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        lstBook.add(new Book(jsonObject.getString("hinh"),
                                jsonObject.getString("tensach"), jsonObject.getDouble("dongia"),
                                jsonObject.getString("masach"), jsonObject.getString("mota")));
                        Log.d("d", "onResponse: "+lstBook.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterBook.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);
    }

    private void setSlide() {
        // lstSlides.add(new ChuDe("1", "DUy", "hinh"));
        loadChuDe();
        adapter_slide = new RecyclerViewSlide_Adapter(this, lstSlides, R.layout.item_recycler_slide);
        recyclerView_slide.setAdapter(adapter_slide);
        recyclerView_slide.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return true;
    }

    private void setControl() {
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        recyclerView_slide = findViewById(R.id.recyclerview_slide);
        recyclerView_book = findViewById(R.id.recyclerview_book);
        listView = findViewById(R.id.listview);
        viewFlipper = findViewById(R.id.viewflipper);

    }

    public void loadChuDe() {
        //127.0.0.1
        String url = Server.urlChuDe;

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        ChuDe chuDe = new ChuDe(jsonObject.getString("machude"), jsonObject.getString("tenchude")
                                , jsonObject.getString("hinhchude"));
                        lstSlides.add(chuDe);


                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "loi" + e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
                adapter_slide.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "loi" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);

    }

    public void loadSlideViewflipper() {

        String url = Server.urlLaySlide;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.d("duy", "onResponse: " + response.getString(i));
                        ImageView hinh = new ImageView(getApplicationContext());
                        Picasso.get().load(Server.urlSlide + response.getString(i)).into(hinh);
                        hinh.setScaleType(ImageView.ScaleType.FIT_XY);
                        viewFlipper.addView(hinh);

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "loi" + e.getMessage(), Toast.LENGTH_LONG).show();

                    }


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "loi" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);


        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);

    }
}
