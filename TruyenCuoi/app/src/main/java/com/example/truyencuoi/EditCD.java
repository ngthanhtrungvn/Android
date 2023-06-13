package com.example.truyencuoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.truyencuoi.databinding.ActivityThemCdBinding;
import com.example.truyencuoi.helper.Utils;
import com.example.truyencuoi.model.topics;

import java.util.ArrayList;

public class EditCD extends AppCompatActivity implements View.OnClickListener{
    ActivityThemCdBinding binding;
    int position ;
    topics ar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemCdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnThem.setText("Save");
        position = getIntent().getExtras().getInt("posision");
        readtblTopic(position);
        binding.etName.setText(ar.getName());
        binding.imageView.setImageBitmap(ar.getImage());
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnThem:
                update(position, binding.etName.getText().toString());
                Toast.makeText(this, "Lưu thành công.", Toast.LENGTH_SHORT).show();
        }
    }
    private void readtblTopic(int position){
        SQLiteDatabase db = openOrCreateDatabase("truyencuoi_sqlite.db", MODE_PRIVATE, null);
        String sql = "select * from tblTopics where id = ?";
        Cursor cs = db.rawQuery(sql,new String[]{String.valueOf(position)});
        if(cs != null){
            while (cs.moveToFirst()){
                Log.e("dp",cs.getInt(0)+cs.getString(1));

                byte[] blob = cs.getBlob(2);
                Bitmap image = Utils.getImage(blob);
                ar = new topics(cs.getInt(0),cs.getString(1),image);

                break;
            }
        }
        db.close();
    }
    private void update(int position, String name){
        SQLiteDatabase db = openOrCreateDatabase("truyencuoi_sqlite.db", MODE_PRIVATE, null);
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        db.update("tblTopics", cv, "id = ?", new String[]{String.valueOf(position)});
        db.close();
    }
}
