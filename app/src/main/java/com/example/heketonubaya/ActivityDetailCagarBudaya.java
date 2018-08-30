package com.example.heketonubaya;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityDetailCagarBudaya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cagar_budaya);

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
