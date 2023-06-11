package com.example.animalcrossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.service.controls.Control;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay;
    CheckBox checkBox1, checkBox2, checkBox3;
    SeekBar seekBar1, seekBar2, seekBar3;
    TextView txtScore;
    final int scoreWin = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        validDateCheckBox();
        mainProgress();
        DisableSeekBar();

    }

    public void mapping() {
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        txtScore = (TextView) findViewById(R.id.txtScore);
    }

    public void validDateCheckBox() {
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
    }

    public void EnableCheckBox() {
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
    }

    public void DisableCheckBox() {
        checkBox1.setEnabled(false);
        checkBox3.setEnabled(false);
        checkBox2.setEnabled(false);
    }

    public void DisableSeekBar() {
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
    }

    public void mainProgress() {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long l) {
                Random r = new Random();
                int number = 5;
                boolean checkWin = false;
                boolean checkFinal = false;
                if (seekBar1.getProgress() >= seekBar1.getMax()) {
                    Toast.makeText(MainActivity.this, "One win", Toast.LENGTH_SHORT).show();
                    checkFinal = true;
                    if (checkBox1.isChecked())
                        checkWin = true;
                } else if (seekBar2.getProgress() >= seekBar2.getMax()) {
                    Toast.makeText(MainActivity.this, "Two win", Toast.LENGTH_SHORT).show();
                    checkFinal = true;
                    if (checkBox2.isChecked())
                        checkWin = true;
                }
                if (seekBar3.getProgress() >= seekBar3.getMax()) {
                    Toast.makeText(MainActivity.this, "Three win", Toast.LENGTH_SHORT).show();
                    checkFinal = true;
                    if (checkBox1.isChecked())
                        checkWin = true;
                }
                if (checkFinal) {
                    int currentScore = Integer.parseInt(txtScore.getText().toString());
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    EnableCheckBox();
                    if (checkWin) {
                        txtScore.setText((currentScore + scoreWin) + "");
                        Toast.makeText(MainActivity.this, "Bạn đã thắng rồi", Toast.LENGTH_SHORT).show();
                    } else {

                        txtScore.setText((currentScore - scoreWin) + "");

                        Toast.makeText(MainActivity.this, "Bạn đã thua rồi", Toast.LENGTH_SHORT).show();
                    }
                }
                seekBar1.setProgress(seekBar1.getProgress() + r.nextInt(number));
                seekBar2.setProgress(seekBar2.getProgress() + r.nextInt(number));
                seekBar3.setProgress(seekBar3.getProgress() + r.nextInt(number));
            }

            @Override
            public void onFinish() {


            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(txtScore.getText().toString()) == 0) {
                    Toast.makeText(MainActivity.this, "Bạn đã hết tiền! Vui lòng đập máy để chơi tiếp nha.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa đặt cược", Toast.LENGTH_SHORT).show();
                    return;
                }

                seekBar2.setProgress(0);
                seekBar1.setProgress(0);
                seekBar3.setProgress(0);
                btnPlay.setVisibility(View.INVISIBLE);
                DisableCheckBox();
                countDownTimer.start();
            }
        });


    }
}