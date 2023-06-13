package com.example.firebase.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase.R;
import com.example.firebase.adapter.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class LoginSignupFragment extends Fragment {

    Context context;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewpagerAdapter viewpagerAdapter;

    public LoginSignupFragment(Context context) {
        this.context = context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_login_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        viewpagerAdapter = new ViewpagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tabLayout.setupWithViewPager(viewPager);
        viewpagerAdapter.addFragment(new LoginTabFragment(), "Đăng nhập");
        viewpagerAdapter.addFragment(new SignupTabFragment(), "Đăng kí");
        viewPager.setAdapter(viewpagerAdapter);
    }

    private void setControl(View view) {
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
    }
}