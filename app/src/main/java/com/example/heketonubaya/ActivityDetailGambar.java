package com.example.heketonubaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ActivityDetailGambar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gambar);
        supportPostponeEnterTransition();

        ImageView imgPost = findViewById(R.id.imgPost);
        imgPost.setImageResource(getIntent().getExtras().getInt("id"));
        imgPost.setTransitionName("image"+getIntent().getExtras().getString("transition"));

        supportStartPostponedEnterTransition();
    }
}
