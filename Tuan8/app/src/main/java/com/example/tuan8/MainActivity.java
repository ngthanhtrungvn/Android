package com.example.tuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(
                Uri.parse("content://com.example.tuan8.DemoContentProdvider/demo"),
                null, null, null, null, null
        );

        if (cursor != null) {
            while(cursor.moveToNext()) {
                Log.e("Doc tu Content Provider", "ID:" + cursor.getString(0));
                Log.e("Doc tu Content Provider", "Name:" + cursor.getString(1   ));
            }
        }
    }
}