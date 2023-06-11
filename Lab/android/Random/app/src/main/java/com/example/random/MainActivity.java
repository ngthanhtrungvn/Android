package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRandom;
    EditText editNumber1, editNumber2;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        editNumber1 = (EditText) findViewById(R.id.editTextNumber1);
        editNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        txtView = (TextView) findViewById(R.id.textViewResult);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number1 = editNumber1.getText().toString().trim();

                String number2 = editNumber2.getText().toString().trim();
                if (number1.isEmpty())
                    Toast.makeText(MainActivity.this, "Số thứ nhất không được rỗng", Toast.LENGTH_SHORT).show();
                else if (number2.isEmpty())
                    Toast.makeText(MainActivity.this, "Số thứ hai không được rỗng", Toast.LENGTH_SHORT).show();
                else {
                    int min = Integer.parseInt(number1);
                    int max = Integer.parseInt(number2);
                    if (min >= max)
                        Toast.makeText(MainActivity.this, "Số thứ hai phải lớn hơn số thứ nhất", Toast.LENGTH_SHORT).show();
                    else {
                        Random r = new Random();
                        int number = r.nextInt(max - min + 1) + min;
                        txtView.setText(number + "");
                    }
                }

            }
        });
    }
}