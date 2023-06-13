package com.example.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.truyencuoi.adapter.ListCDAdapter;
import com.example.truyencuoi.databinding.ActivityDanhsachCdBinding;
import com.example.truyencuoi.helper.Utils;
import com.example.truyencuoi.model.topics;

import java.util.ArrayList;

public class DanhsachCD extends AppCompatActivity {
    ActivityDanhsachCdBinding binding;
    ArrayList<topics> ar = new ArrayList<>();
    ListCDAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDanhsachCdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        readtblTopic();
        adapter = new ListCDAdapter(this,ar);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager( new LinearLayoutManager(this.getBaseContext()));
    }
    private void readtblTopic(){
        SQLiteDatabase db = openOrCreateDatabase("truyencuoi_sqlite.db", MODE_PRIVATE, null);
        String sql = "select * from tblTopics";
        Cursor cs = db.rawQuery(sql,null);
        if(cs != null){
            while (cs.moveToNext()){
                byte[] blob = cs.getBlob(2);
                Bitmap image = Utils.getImage(blob);
                topics chude = new topics(cs.getInt(0),cs.getString(1),image);
                ar.add(chude);
            }
        }
    }
}