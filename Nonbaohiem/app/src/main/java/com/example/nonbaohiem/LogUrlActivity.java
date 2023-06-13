package com.example.nonbaohiem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogUrlActivity extends AppCompatActivity {

    EditText txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_url);
        mapping();

    }

    private void mapping() {
        txtUrl = findViewById(R.id.txtUrl);
    }

    public void CONNECT(View v) {
        String url = txtUrl.getText().toString().trim();
        txtUrl.setError(null);
        if (!url.isEmpty()) {
            if (!url.contains("http"))
                url = "https://" + url;
            else
                url=url.replace("http://", "https://");

            Intent intent = new Intent(LogUrlActivity.this, MainActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        } else {
            txtUrl.setError("Enter url website");
            txtUrl.requestFocus();

        }
    }
}