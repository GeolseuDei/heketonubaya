package com.example.heketonubaya;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

//import com.jaredrummler.materialspinner.MaterialSpinner;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityRegister extends AppCompatActivity {

    ImageView imgUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //region Framelayout Upload
        FrameLayout frmUpload = findViewById(R.id.frmUpload);
        frmUpload.setOnClickListener(new View.OnClickListener() {
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

        //region Material Spinner
        final List<String> stringList = new ArrayList<>();
        stringList.add("wirausaha");
        stringList.add("puskesmas");
        stringList.add("PMK");
        stringList.add("Koperasi");
        stringList.add("Sekolah");
        stringList.add("Fasilitas Olahraga");
        stringList.add("Cagar Budaya");
        final MaterialSpinner spnInstansi = findViewById(R.id.spnInstansi);
        spnInstansi.setItems(stringList);
        //endregion

        //region Button submit
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtUsername, edtPassword, edtRepassword;
                edtUsername = findViewById(R.id.edtUsername);
                edtPassword = findViewById(R.id.edtPassword);
                edtRepassword = findViewById(R.id.edtRepassword);

                String password = edtPassword.getText().toString();

                final BitmapDrawable bitmapDrawable = (BitmapDrawable) imgUpload.getDrawable();
                final Bitmap bitmap = bitmapDrawable.getBitmap();

                if(password.equals(edtRepassword.toString())){
                    final Intent intent = new Intent(getApplicationContext(), ActivityRegistrasiInstansi.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    intent.putExtra("password", password);
                    intent.putExtra("foto", imageToString(bitmap));
                    intent.putExtra("instansi", stringList.get(spnInstansi.getSelectedIndex()));
                    startActivity(intent);
                }
            }
        });
        //endregion
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                final Uri uri = data.getData();
                final Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgUpload.setImageBitmap(bitmap);
                imgUpload.setVisibility(View.VISIBLE);

                TextView txtUpload = findViewById(R.id.txtUpload);
                txtUpload.setVisibility(View.GONE);

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
