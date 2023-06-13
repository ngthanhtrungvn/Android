package com.example.choosebird;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout myTable;
    private static final int rows = 3;
    private static final int cols = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mapping();
        addViewForMyTable();
    }

    private void addViewForMyTable() {
        Collections.shuffle(MainActivity.lstImg);

        for (int i = 1; i <= rows; i++) {

            TableRow tableRow = new TableRow(this);
            for (int j = 1; j <= cols; j++) {
                ImageView img = new ImageView(this);
                Resources r = getResources();
                int px =(int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        100,
                        r.getDisplayMetrics()
                );
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                img.setLayoutParams(layoutParams);
                int index = cols * (i - 1) + j - 1;
                int idImg = getResources().getIdentifier(MainActivity.lstImg.get(index), "drawable", getPackageName());
                img.setImageResource(idImg);
                img.setBackgroundResource(R.color.yellow);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = getIntent();
                        intent.putExtra("name", MainActivity.lstImg.get(index));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                tableRow.addView(img);

            }
            myTable.addView(tableRow);
        }
    }


    private void mapping() {
        myTable = (TableLayout) findViewById(R.id.myTable);
    }
}