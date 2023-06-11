package com.example.tuan9;

import android.util.Log;

public class DemoThread extends Thread{
    @Override
    public void run() {
        super.run();

        for(int i = 0; i < 20; i++) {
            Log.e("Thread run", String.valueOf(i));

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException();
            }

        }
    }
}
