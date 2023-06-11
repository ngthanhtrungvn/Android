package com.example.reccylclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Fragment fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fm=new Fragment1();
        replaceFragment();

    }

    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.btnFragment1:
                fm=new Fragment1();
                break;
            case R.id.btnFragment2:
                fm=new Fragment2();
                break;
        }
        replaceFragment();

    }
    private void replaceFragment()
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_host,fm);
        fragmentTransaction.commit();
    }
}