package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        setControl();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new fragment_home(this), "Home");
        viewPagerAdapter.addFragment(new fragment_dashboard(this), "Dashboard");
        viewPagerAdapter.addFragment(new fragment_notification(this), "Notification");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_dashboard_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_notifications_24);

        BadgeDrawable badgeDrawable1 = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable1.setNumber(3);
        badgeDrawable1.setVisible(true);

        BadgeDrawable badgeDrawable2 = tabLayout.getTabAt(1).getOrCreateBadge();
        badgeDrawable2.setNumber(3);
        badgeDrawable2.setVisible(true);

        BadgeDrawable badgeDrawable3 = tabLayout.getTabAt(2).getOrCreateBadge();
        badgeDrawable3.setNumber(3);
        badgeDrawable3.setVisible(true);
    }

    private void setControl() {
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
    }
}