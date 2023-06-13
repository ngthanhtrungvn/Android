package com.example.firebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.firebase.R;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    Context context;
    int layout;
    ArrayList<Integer> listImage;

    public SliderAdapter(Context context, int layout, ArrayList<Integer> listImage) {
        this.context = context;
        this.layout = layout;
        this.listImage = listImage;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(layout, container, false);
        ImageView image = view.findViewById(R.id.slider_image);
        int slider_item = listImage.get(position);
        Glide.with(context).load(slider_item).into(image);
        container.addView(view);
        return view;
    }


    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
