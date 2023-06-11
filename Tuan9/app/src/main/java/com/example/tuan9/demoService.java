package com.example.tuan9;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class demoService extends IntentService {

    public demoService() {
        super("DemoService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        onStart(intent, startId);
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for(int i = 0; i < 20; i++) {
            Log.e("Thread run", String.valueOf(i));

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new  RuntimeException(e);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
