package com.example.heketonubaya;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDetailFasilitasOlahraga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fasilitas_olahraga);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Detail Fasilitas Olahraga");

        POJO_FasilitasOlahraga pojo_fasilitasOlahraga = getIntent().getExtras().getParcelable("pojo_fasilitas_olahraga");

        TextView textView = findViewById(R.id.tv_nama);
        TextView textView1 = findViewById(R.id.tv_alamat);
        TextView textView2 = findViewById(R.id.tv_kecamatan);
        TextView textView3 = findViewById(R.id.tv_kelurahan);
        TextView textView4 = findViewById(R.id.tv_kondisi);
        TextView textView5 = findViewById(R.id.tv_tahundibangun);
        TextView textView6 = findViewById(R.id.tv_luas);

        textView.setText(pojo_fasilitasOlahraga.getNama_prasarana());
        textView1.setText("Alamat : " + pojo_fasilitasOlahraga.getAlamat());
        textView2.setText("Kecamatan : " + pojo_fasilitasOlahraga.getKecamatan());
        textView3.setText("Kelurahan : " + pojo_fasilitasOlahraga.getKelurahan());
        textView4.setText("Kondisi : " + pojo_fasilitasOlahraga.getKondisi_prasarana());
        textView5.setText("Tahun dibangun : " + pojo_fasilitasOlahraga.getTahun_dibangun());
        textView6.setText("Luas : " + pojo_fasilitasOlahraga.getLuas() + " meter");

        Button btnApply = findViewById(R.id.btn_apply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ActivityApply.class));
            }
        });
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
