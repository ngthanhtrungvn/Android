package com.example.tuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPageActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        ArrayList<Fragment> items = new ArrayList<>();
        items.add(DetailDemoFragment.newInstance("Page 1"));
        items.add(DetailDemoFragment.newInstance("Page 2"));
        items.add(DetailDemoFragment.newInstance("Page 3"));
        items.add(DetailDemoFragment.newInstance("Page 4"));
        items.add(DetailDemoFragment.newInstance("Page 5"));


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), items);
        viewPager.setAdapter(adapter);
    }


        class PagerAdapter extends FragmentPagerAdapter {
            ArrayList<Fragment> items;
            public PagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> items) {
                super(fm);
                this.items = items;
            }

            @NonNull
            @Override
            public Fragment getItem(int i) {
                return items.get(i);
            }

            @Override
            public int getCount() {
                return items.size();
            }
        }
    }
