package com.example.heketonubaya;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class ActivitySplash extends AppCompatActivity {

    CountDownTimer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        c = new CountDownTimer(2000,1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                ImageView imageView = findViewById(R.id.imgLogo);
                startActivity(new Intent(getApplicationContext(), ActivityLogin.class), makeSceneTransitionAnimation(ActivitySplash.this, imageView, ViewCompat.getTransitionName(imageView)).toBundle());
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        c.cancel();
    }
}
