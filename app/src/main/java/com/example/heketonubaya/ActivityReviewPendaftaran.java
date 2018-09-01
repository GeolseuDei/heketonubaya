package com.example.heketonubaya;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class ActivityReviewPendaftaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_pendaftaran);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Review Pendaftaran");

        ArrayList<POJO_ReviewPendaftaran> reviewPendaftarans = new ArrayList<>();
        reviewPendaftarans.add(new POJO_ReviewPendaftaran("1","Sekolah Kemasyarakatan","pkm","melayani dengan hati","jl. H.Rasuna Said","0878764986875","surat_pkm.png"));
        reviewPendaftarans.add(new POJO_ReviewPendaftaran("2","usaha salon dan konter hp","wirausaha","profesinal di segala bidang","jl padang bulia","088687694758","surat_wiraswasta.jpg"));
        reviewPendaftarans.add(new POJO_ReviewPendaftaran("3","minimarket","wirausaha","harga dijamin yang termurah, sedia segala kebutuhan sekolah dan kantor","jl senik","0856754737698","surat_wiraswasta2.jpg"));

        RecyclerView rclKonten = findViewById(R.id.rclKonten);
        rclKonten.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rclKonten.setAdapter(new AdapterReviewPendaftaran(reviewPendaftarans, this));
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
