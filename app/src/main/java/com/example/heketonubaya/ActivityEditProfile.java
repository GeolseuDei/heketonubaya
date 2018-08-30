package com.example.heketonubaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final POJO_User pojo_user = getIntent().getExtras().getParcelable("pojo_user");

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
