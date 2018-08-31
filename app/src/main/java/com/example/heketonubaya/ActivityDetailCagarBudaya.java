package com.example.heketonubaya;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class ActivityDetailCagarBudaya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cagar_budaya);
        supportPostponeEnterTransition();

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Detail Cagar Budaya");

        TextView textView = findViewById(R.id.tv_nama);
        TextView textView1 = findViewById(R.id.tv_alamat);
        TextView textView2 = findViewById(R.id.tv_kecamatan);
        TextView textView3 = findViewById(R.id.tv_kelurahan);
        TextView textView4 = findViewById(R.id.tv_kondisi);
        TextView textView6 = findViewById(R.id.tv_nomorsk);
        TextView textView7 = findViewById(R.id.tv_kepemilikan);

        POJO_CagarBudaya pojo_cagarBudaya = getIntent().getExtras().getParcelable("pojo_cagar_budaya");
        textView.setText(pojo_cagarBudaya.getNama_bangunan());
        textView1.setText("Alamat : " + pojo_cagarBudaya.getAlamat());
        textView2.setText("Kecamatan : " + pojo_cagarBudaya.getKecamatan());
        textView3.setText("Kelurahan : " + pojo_cagarBudaya.getKelurahan());
        textView4.setText("Kondisi : " + pojo_cagarBudaya.getKondisi());
        textView6.setText("Nomor SK : " + pojo_cagarBudaya.getNomor_sk());
        textView7.setText("Milik " + pojo_cagarBudaya.getKepemilikan());

        final String transition = getIntent().getExtras().getString("transition");

        final Button btnApply = findViewById(R.id.btn_apply);
        btnApply.setTransitionName("apply"+transition);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityApply.class);
                intent.putExtra("transition", transition);
                Pair<View, String> pair1 = Pair.create((View) btnApply, btnApply.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation(ActivityDetailCagarBudaya.this, pair1);
                startActivity(intent, options.toBundle());
            }
        });

        final ImageView imageView = findViewById(R.id.img);
        imageView.setTransitionName("image"+transition);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityDetailGambar.class);
                intent.putExtra("id", R.drawable.monumen);
                intent.putExtra("transition", transition);
                Pair<View, String> pair1 = Pair.create((View) imageView, imageView.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation(ActivityDetailCagarBudaya.this, pair1);
                startActivity(intent, options.toBundle());
            }
        });

        supportStartPostponedEnterTransition();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
