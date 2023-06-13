package com.example.truyencuoi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;

import com.example.truyencuoi2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final String AUTHORITY = "com.example.truyencuoi.ContentProdvider.CDProdvider";
    static final String CONTENT_PATH =  "backupdata";
    static final String URL = "content://" + AUTHORITY + "/" + CONTENT_PATH;
    static final Uri CONTENT_URI = Uri.parse(URL);
    ActivityMainBinding binding;
    ArrayList<topics> chude = new ArrayList<>();
    ListCDAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Cursor c = getContentResolver().query(CONTENT_URI, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                byte[] blob = c.getBlob(2);
                Bitmap image = Utils.getImage(blob);
                chude.add(new topics(c.getInt(0),c.getString(1),image));
            } while (c.moveToNext());
        }
        adapter = new ListCDAdapter(this,chude);
        binding.list.setAdapter((ListAdapter) adapter);
    }
}