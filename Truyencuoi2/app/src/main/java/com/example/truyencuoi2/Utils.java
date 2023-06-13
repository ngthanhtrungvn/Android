package com.example.truyencuoi2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Utils {
    public static Bitmap getImage(byte[] image){
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }
    public static byte[] getBytes(ImageView image){
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bm = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;
    }
}
