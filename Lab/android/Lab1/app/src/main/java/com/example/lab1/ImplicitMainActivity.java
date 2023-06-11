package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImplicitMainActivity extends AppCompatActivity {

    ImageView imgPhone,imgMap,imgMedia,imgCamera,imgPhoto,imgMusic;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_main);
        imgPhone=findViewById(R.id.imgPhone);
        imgMedia=findViewById(R.id.imgMedia);
        imgCamera=findViewById(R.id.imgCamera);
        imgPhoto=findViewById(R.id.imgPhoto);
        imgMusic=findViewById(R.id.imgMusic);
        imgMap=findViewById(R.id.imgMap);
        View.OnClickListener myclick=new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                int id= view.getId();
                switch (id)
                {
                    case R.id.imgPhone:
                        if(checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getApplicationContext(),"Permission isn't granted",Toast.LENGTH_SHORT).show();
                            //xin quyen
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},111);
                        } else {
                            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0703337662"));
                            startActivity(intent);
                        }
                        break;
                    case R.id.imgMedia:
                        intent=new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                        startActivity(intent);
                        break;
                    case R.id.imgCamera:
                        intent=new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
                        startActivity(intent);
                        break;
                    case R.id.imgPhoto:
                        intent=new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/pictures/*");
                        startActivity(intent);
                        break;
                    case R.id.imgMusic:
                        intent = new Intent("android.intent.action.MUSIC_PLAYER");
                        startActivity(intent);
                        break;
                    case R.id.imgMap:
                        intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps"));
                        startActivity(intent);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + id);
                }
            }
        };
        imgPhone.setOnClickListener(myclick);
        imgMedia.setOnClickListener(myclick);
        imgCamera.setOnClickListener(myclick);
        imgPhoto.setOnClickListener(myclick);
        imgMusic.setOnClickListener(myclick);
        imgMap.setOnClickListener(myclick);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==111 &&grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0703337662"));
            startActivity(intent);
        }
    }
}