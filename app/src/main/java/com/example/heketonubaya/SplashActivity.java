package com.example.heketonubaya;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

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
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        c.cancel();
    }
}
