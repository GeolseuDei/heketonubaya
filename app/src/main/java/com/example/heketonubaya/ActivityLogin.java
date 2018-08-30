package com.example.heketonubaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //region Button Login
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText etUsername, etPassword;
                etUsername = findViewById(R.id.et_username);
                etPassword = findViewById(R.id.et_password);

                Webservice webservice = new Webservice();
                POJO_User pojo_user = new POJO_User();

                if(webservice.login(etUsername.getText().toString(),  etPassword.getText().toString(), pojo_user)){
                    final Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                    intent.putExtra("pojo_user", pojo_user);
                    startActivity(intent);
                }else{
                    //gagal login
                }
            }
        });
        //endregion
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
