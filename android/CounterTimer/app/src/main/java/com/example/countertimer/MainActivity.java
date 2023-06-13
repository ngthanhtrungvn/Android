package com.example.countertimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch _switch;
    ProgressBar process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _switch=(Switch) findViewById(R.id.switch1);
        process=(ProgressBar) findViewById(R.id.progressBar);
        _switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CountDownTimer coutDownTimer=new CountDownTimer(10000,500) {
                    @Override
                    public void onTick(long l) {
                        int currentTime=process.getProgress();
                        if(currentTime==100)
                            currentTime=0;
                            process.setProgress(currentTime+10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this,"Hết giờ",Toast.LENGTH_SHORT).show();
                    }
                };
                if(b)
                {
                  coutDownTimer.start();
                }
                else
                {
                    coutDownTimer.onFinish();
                }
            }
        });
    }

}