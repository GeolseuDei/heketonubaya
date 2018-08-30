package com.example.heketonubaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class ActivityEditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //region Spinner Kecamatan
        MaterialSpinner spnKecamatan = findViewById(R.id.spnKecamatan);
        spnKecamatan.setItems("Asemrowo","Sukomanunggal","Tandes");
        spnKecamatan.setSelectedIndex(1);
        //endregion

        //region Spinner Kelurahan
        MaterialSpinner spnKelurahan = findViewById(R.id.spnKelurahan);
        spnKelurahan.setItems("Asem Rowo","Manukan Kulon","Tanjungsari");
        spnKelurahan.setSelectedIndex(2);
        //endregion

        //region Editteks username
        final POJO_User pojo_user = getIntent().getExtras().getParcelable("pojo_user");
        EditText edt_user_name = findViewById(R.id.et_user_name);
        edt_user_name.setText(pojo_user.getUsername());
        //endregion

        //region Button SImpan
        Button btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_user_name = findViewById(R.id.et_user_name);
                Webservice webservice = new Webservice();
                if(webservice.updateNamaProfil(et_user_name.getText().toString(), pojo_user.getId())){
                    startActivity(new Intent(getApplicationContext(), ActivityLogin.class));
                }

            }
        });
        //endregion
    }
}
