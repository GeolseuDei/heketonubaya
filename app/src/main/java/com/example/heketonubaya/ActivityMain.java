package com.example.heketonubaya;

import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    boolean backPressedOnce = false;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Set fragment awal
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new FragmentHome());
        ft.commit();
        //endregion

        LinearLayout layoutHome, layoutProfile, layoutTimeline, layoutRequest;

        //region Linear Layout layouthome
        layoutHome = findViewById(R.id.layout_home);
        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentHome());
                ft.commit();
            }
        });
        //endregion

        //region Linear Layout profile
        layoutProfile = findViewById(R.id.layout_profile);
        layoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("pojo_user", getIntent().getExtras().getParcelable("pojo_user"));

                ft = getSupportFragmentManager().beginTransaction();
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);

                ft.replace(R.id.mainFrame, fragmentProfile);
                ft.commit();
            }
        });
        //endregion

        //region Linear Layout Timeline
        layoutTimeline = findViewById(R.id.layout_timeline);
        layoutTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentTimeline());
                ft.commit();
            }
        });
        //endregion

        //region Linear Layout Request
        layoutRequest = findViewById(R.id.layout_request);
        layoutRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentRequest());
                ft.commit();
            }
        });
        //endregion

    }

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            finishAffinity();
        } else {
            backPressedOnce = true;
            Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backPressedOnce = false;
                }
            }, 1000);
        }
    }
}
