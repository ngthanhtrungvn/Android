package com.example.tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        checkInternetConnection();
//        connect();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:4567/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        APIServer api = retrofit.create(APIServer.class);
        api.hello().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.e("Body", user.getName());
                Log.e("Body", user.getCCCD());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
//    class connectAPI extends AsyncTask<Void, Integer, Void> {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            connect();
//            return null;
//        }
//    }

//    private void connect() {
//        try {
//            URL url = new URL("http://10.0.2.2:4567/hello");
//            URLConnection urlConnection = url.openConnection();
//            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
//            Log.e("Status code", String.valueOf(httpURLConnection.getResponseCode()));
//            Log.e("Status message", String.valueOf(httpURLConnection.getResponseMessage()));
//
//            InputStream is = httpURLConnection.getInputStream();
////            InputStream is = httpURLConnection.getErrorStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//            }
//
//            ObjectMapper mapper = new ObjectMapper();
//            User user = mapper.readValue(sb.toString(), User.class);
//
//
//            Log.e("Response body", user.getName());
//            Log.e("Response body", user.getCCCD());
//
//        }
//       catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//       } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }



//    private boolean checkInternetConnection() {
//        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
//        if (networkInfo == null) {
//            Toast.makeText(this, "No default network is currently active", Toast.LENGTH_LONG).show();
//            return false;
//        }
//        if (!networkInfo.isConnected()) {
//            Toast.makeText(this, "Network is not connected", Toast.LENGTH_LONG).show();
//            return false;
//        }
//        if (!networkInfo.isAvailable()) {
//            Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
//            return false;
//        }
//        Toast.makeText(this, "Network OK", Toast.LENGTH_LONG).show();
//        return true;
//    }
}