package com.example.tuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    TextView tvDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDemo.findViewById(R.id.tv_demo);

        Intent intent = new Intent(this, demoService.class);
        startService(intent);
        DemoThread t = new DemoThread();
        t.start();

        new DemoAsyncTask().execute();
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                int i = message.getData().getInt("so");
                return true;
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 20; i++) {
                    Log.e("Thread run", String.valueOf(i));
                    Message m = handler.obtainMessage();
                    Intent intent = new Intent();
                    intent.putExtra("so", i);
                    m.setData(intent.getExtras());
                    handler.sendMessage(m);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        throw new  RuntimeException();
                    }

                }
            }
        });

        t.start();;
    }

    class DemoAsyncTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = 0; i < 20; i++) {
                Log.e("Thread run", String.valueOf(i));

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new  RuntimeException(e);
                }
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvDemo.setText("onPreExecute");

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvDemo.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvDemo.setText("onPreExecute");
        }
    }

}