package com.example.truyencuoi;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.truyencuoi.databinding.ActivityThemCdBinding;
import com.example.truyencuoi.helper.Utils;
import com.example.truyencuoi.model.topics;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemCD extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_IMAGE_SIGNUP = 928;
    ActivityThemCdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemCdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnThem:
                try {
                    String name = binding.etName.getText().toString();
                    byte[] inputdata = Utils.getBytes(binding.imageView);
                    insert(name, inputdata);
                    Toast.makeText(this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;
            case R.id.imageView:
                if(this.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},111);
                } else {
                     intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_CODE_IMAGE_SIGNUP);
                }

                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_IMAGE_SIGNUP && resultCode == ((Activity) this).RESULT_OK && data != null) {
            Uri uri = data.getData();
            binding.imageView.setImageURI(uri);
//            try {
//                InputStream inputStream = this.getContentResolver().openInputStream(uri);
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                binding.imageView.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
    public String getRealPathFromURI(Uri contentUri) {
        String path = null;
        String[] proj = {MediaStore.MediaColumns.DATA};
        Cursor cursor = this.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }
    private void insert(String name, byte[] image) {
        SQLiteDatabase db = openOrCreateDatabase("truyencuoi_sqlite.db", MODE_PRIVATE, null);
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("image", image);
        db.insert("tblTopics", null, cv);
        db.close();
    }
}