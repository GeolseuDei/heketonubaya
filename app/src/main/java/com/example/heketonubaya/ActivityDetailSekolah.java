package com.example.heketonubaya;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityDetailSekolah extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    double lat = 0, lng = 0;
    POJO_Sekolah pojo_sekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sekolah);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Detail Sekolah");

        pojo_sekolah = getIntent().getExtras().getParcelable("pojo_sekolah");

        lat = Double.parseDouble(pojo_sekolah.getLat());
        lng = Double.parseDouble(pojo_sekolah.getLng());

        TextView textView = findViewById(R.id.tv_nama);
        TextView textView1 = findViewById(R.id.tv_alamat);

        textView.setText(pojo_sekolah.getNama());
        textView1.setText(pojo_sekolah.getAlamat());

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sekolah = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sekolah).title(pojo_sekolah.getNama()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sekolah, 15));
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
