package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageAnimation;
    Button btnFadein,btnFadeout,btnRotate,btnMove,btnZoomin,btnFadeinRotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        setControl();
        btnFadein.setOnClickListener(this);
        btnFadeout.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        btnZoomin.setOnClickListener(this);
    }
    private void setControl() {
        imageAnimation=findViewById(R.id.imageAnimation);
        btnFadein=findViewById(R.id.btnFadein);
        btnFadeout=findViewById(R.id.btnFadeout);
        btnRotate=findViewById(R.id.btnRotate);
        btnMove=findViewById(R.id.btnMove);
        btnZoomin=findViewById(R.id.btnZoomin);
        btnFadeinRotate=findViewById(R.id.btnFadeinRotate);
    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btnFadein:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein));
                break;
            case R.id.btnFadeout:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout));
                break;
            case R.id.btnRotate:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate));
                break;
            case R.id.btnMove:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move));
                break;
            case R.id.btnZoomin:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin));
                break;
            case R.id.btnFadeinRotate:
                imageAnimation.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_rotate));
                break;
        }
    }
}