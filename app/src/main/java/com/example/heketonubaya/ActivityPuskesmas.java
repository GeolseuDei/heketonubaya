package com.example.heketonubaya;

import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ActivityPuskesmas extends AppCompatActivity {


    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    ArrayList<POJO_Puskesmas> pojo_puskesmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puskesmas);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        StrictMode.ThreadPolicy policy;
        policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setTitle("Puskesmas");

        pojo_puskesmas = new ArrayList<>();

        //region Recyclerview Konten
        RecyclerView rclKonten = findViewById(R.id.rclKonten);
        rclKonten.setLayoutManager(new LinearLayoutManager(this));
        //endregion

        HttpURLConnection conn = null;
        URL url = null;
        try {
            url = new URL(new TargetAPI().getTarget_url() + "puskesmas.php");
        } catch (MalformedURLException e) {
            Log.e("HEKETON", "url " + e.getMessage());
        }

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);

            conn.setDoInput(true);
            conn.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("namaapi", "jadwal_kedatangan_kapal");
            String query = builder.build().getEncodedQuery();

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            conn.connect();

            int response_code = conn.getResponseCode();

            if (response_code == HttpURLConnection.HTTP_OK) {

                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(result.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        POJO_Puskesmas w = new POJO_Puskesmas();
                        w.setId(jsonArray.getJSONObject(i).getString("id"));
                        w.setNama_puskesmas(jsonArray.getJSONObject(i).getString("puskesmas"));
                        w.setKode_puskesmas(jsonArray.getJSONObject(i).getString("kode_puskesmas"));
                        w.setKelurahan(jsonArray.getJSONObject(i).getString("kelurahan"));
                        w.setKecamatan(jsonArray.getJSONObject(i).getString("kecamatan"));
                        w.setAlamat(jsonArray.getJSONObject(i).getString("alamat"));
                        pojo_puskesmas.add(w);
                    }
                    rclKonten.setAdapter(new AdapterPuskesmas(pojo_puskesmas, this));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Response Code : " + response_code, Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Log.e("HEKETON", "http " + e.getMessage());
        } finally {
            conn.disconnect();
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
