package com.example.heketonubaya;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class ActivityDetailWirausaha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wirausaha);
        supportPostponeEnterTransition();

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Detail Wirausaha");

        final POJO_Wirausaha pojo_wirausaha = getIntent().getExtras().getParcelable("pojo_wirausaha");
        final String transition = getIntent().getExtras().getString("transition_name");

        TextView textView = findViewById(R.id.tv_nama);
        TextView textView1 = findViewById(R.id.tv_nik);
        TextView textView2 = findViewById(R.id.tv_alamat);
        TextView textView3 = findViewById(R.id.tv_kecamatan);
        TextView textView4 = findViewById(R.id.tv_jenis_usaha);
        TextView textView5 = findViewById(R.id.tv_penanggung_jawab);

        textView.setText(pojo_wirausaha.getNama_kupp());
        textView1.setText("NIK : " + pojo_wirausaha.getNik());
        textView2.setText("Alamat : " + pojo_wirausaha.getAlamat());
        textView3.setText("Kecamatan : " + pojo_wirausaha.getKecamatan());
        textView4.setText("Jenis Usaha : " + pojo_wirausaha.getJenis_usaha());
        textView5.setText(pojo_wirausaha.getPenanggungjawab());

        Button btnSMS, btnCall;
        btnSMS = findViewById(R.id.btn_sendMessage);
        btnCall = findViewById(R.id.btn_call);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + pojo_wirausaha.getTelepon())));
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission(pojo_wirausaha);
            }
        });


        final Button btnApply = findViewById(R.id.btn_apply);
        btnApply.setTransitionName("apply"+transition);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityApply.class);
                intent.putExtra("transition", transition);
                Pair<View, String> pair1 = Pair.create((View) btnApply, btnApply.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation(ActivityDetailWirausaha.this, pair1);
                startActivity(intent, options.toBundle());
            }
        });

        final ImageView imageView = findViewById(R.id.img);

        textView.setTransitionName(transition);
        imageView.setTransitionName("image"+transition);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityDetailGambar.class);
                intent.putExtra("id", R.drawable.fotowirausaha);
                intent.putExtra("transition", transition);
                Pair<View, String> pair1 = Pair.create((View) imageView, imageView.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation(ActivityDetailWirausaha.this, pair1);
                startActivity(intent, options.toBundle());
            }
        });

        supportStartPostponedEnterTransition();
    }

    boolean granted = false;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private void requestPermission(POJO_Wirausaha pojo_wirausaha) {
        if (ContextCompat.checkSelfPermission(ActivityDetailWirausaha.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat
                    .requestPermissions(ActivityDetailWirausaha.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            granted = true;
        }
        if (granted) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + pojo_wirausaha.getTelepon()));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    granted = true;
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();

                } else {
                    // Permission Denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
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
