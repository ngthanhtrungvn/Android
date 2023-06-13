package com.example.firebase.fragment;

import static com.example.firebase.R.drawable.b1;
import static com.example.firebase.R.drawable.b2;
import static com.example.firebase.R.drawable.b3;
import static com.example.firebase.R.drawable.b4;
import static com.example.firebase.R.drawable.card1;
import static com.example.firebase.R.drawable.card2;
import static com.example.firebase.R.drawable.card3;
import static com.example.firebase.R.drawable.card4;
import static com.example.firebase.R.drawable.discountberry;
import static com.example.firebase.R.drawable.discountbrocoli;
import static com.example.firebase.R.drawable.discountmeat;
import static com.example.firebase.R.drawable.ic_baseline_home_24;
import static com.example.firebase.R.drawable.ic_home_fish;
import static com.example.firebase.R.drawable.ic_home_fruits;
import static com.example.firebase.R.drawable.ic_home_meats;
import static com.example.firebase.R.drawable.ic_home_veggies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firebase.R;
import com.example.firebase.activity.AllCategoryActivity;
import com.example.firebase.adapter.CategoryAdapter;
import com.example.firebase.adapter.DiscountedProductAdapter;
import com.example.firebase.adapter.RecentlyViewedAdapter;
import com.example.firebase.adapter.SliderAdapter;
import com.example.firebase.model.Category;
import com.example.firebase.model.DiscountedProducts;
import com.example.firebase.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class FragmentHome extends Fragment {

    Context context;
    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    SliderAdapter sliderAdapter;
    ArrayList listImage;
    Timer timer;
    Toolbar toolbar;

    public FragmentHome(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.firebase.fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        addDataDiscounted();
        addDataCategory();
        addDataRecenly();

        listImage = getImageSlider();
        sliderAdapter = new SliderAdapter(context, R.layout.slider_image_item, listImage);
        viewPager.setAdapter(sliderAdapter);
        circleIndicator.setViewPager(viewPager);
        sliderAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSliderImage();

        toolbar.setNavigationIcon(ic_baseline_home_24);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AllCategoryActivity.class);
                startActivity(i);
            }
        });


        setDiscountedRecycler(context, discountedProductsList);
        setCategoryRecycler(context, categoryList);
        setRecentlyViewedRecycler(context, recentlyViewedList);

    }

    private void addDataRecenly() {
        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "₹ 80", "1", "KG", card4, b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG", card3, b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 30", "1", "KG", card2, b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", card1, b2));
    }

    private void addDataCategory() {
        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, ic_home_fruits));
        categoryList.add(new Category(2, ic_home_fish));
        categoryList.add(new Category(3, ic_home_meats));
        categoryList.add(new Category(4, ic_home_veggies));
        categoryList.add(new Category(5, ic_home_fruits));
        categoryList.add(new Category(6, ic_home_fish));
        categoryList.add(new Category(7, ic_home_meats));
        categoryList.add(new Category(8, ic_home_veggies));
    }

    private void addDataDiscounted() {
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, discountberry));
        discountedProductsList.add(new DiscountedProducts(2, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, discountmeat));
        discountedProductsList.add(new DiscountedProducts(4, discountberry));
        discountedProductsList.add(new DiscountedProducts(5, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6, discountmeat));
    }

    private void setControl(View view) {
        discountRecyclerView = view.findViewById(R.id.discountedRecycler);
        categoryRecyclerView = view.findViewById(R.id.categoryRecycler);
        allCategory = view.findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = view.findViewById(R.id.recently_item);
        viewPager = view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.circleindicator);
        toolbar = view.findViewById(R.id.toolbarmain);
    }

    private void autoSliderImage() {
        if (timer == null)
            timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = listImage.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        } else
                            viewPager.setCurrentItem(0);
                    }
                });
            }
        }, 500, 5000);
    }


    private ArrayList<Integer> getImageSlider() {
        ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(R.drawable.card1);
        listImage.add(R.drawable.card2);
        listImage.add(R.drawable.card3);
        return listImage;
    }

    private void setDiscountedRecycler(Context context, List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(context, dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setCategoryRecycler(Context context, List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(context, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(Context context, List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(context, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}