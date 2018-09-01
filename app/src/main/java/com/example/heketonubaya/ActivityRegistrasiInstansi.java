package com.example.heketonubaya;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ActivityRegistrasiInstansi extends AppCompatActivity {

    ImageView imgUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regustrasi_instansi);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Registrasi Instansi");

        //region Get Bundle
        final String username, password, foto, instansi;
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        foto = getIntent().getStringExtra("foto");
        instansi = getIntent().getStringExtra("instansi");
        //endregion

        //region Button Upload
        Button btnUpload = findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select image from gallery"), 1);

            }
        });
        //endregion

        imgUpload = findViewById(R.id.imgUpload);

        //region Button submit
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                EditText edtNama, edtAlamat, edtTelpon;
//                edtNama = findViewById(R.id.edtNama);
//                edtAlamat = findViewById(R.id.edtAlamat);
//                edtTelpon = findViewById(R.id.edtTelpon);
//
//                final BitmapDrawable bitmapDrawable = (BitmapDrawable) imgUpload.getDrawable();
//                final Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                Webservice webservice = new Webservice();
//                if (webservice.register(username, password, foto, imageToString(bitmap), edtNama.getText().toString(), edtAlamat.getText().toString(), edtTelpon.getText().toString())) {
//
//                    //region ALert DIalog
//
//                    //endregion
//
//                }

//                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                builder.setTitle("Terimakasih").setMessage("Data anda telah kami catat, mohon menunggu pemberitahuan berikutnya").show();
//                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//
//                    }
//                });

                Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
            }
        });
        //endregion
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                final Uri uri = data.getData();
                final Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgUpload.setImageBitmap(bitmap);
                imgUpload.setVisibility(View.VISIBLE);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }
}
