package com.example.heketonubaya;

import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class ActivityCagarBudaya extends AppCompatActivity {

    ArrayList<POJO_CagarBudaya> pojo_cagarBudayas;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cagar_budaya);

        StrictMode.ThreadPolicy policy;
        policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setTitle("Cagar Budaya");

        pojo_cagarBudayas = new ArrayList<>();

        //region Recyclerview Konten
        RecyclerView rclKonten = findViewById(R.id.rclKonten);
        rclKonten.setLayoutManager(new LinearLayoutManager(this));
        //endregion

        HttpURLConnection conn = null;
        URL url = null;
        try {
            url = new URL(new TargetAPI().getTarget_url() + "cagar_budaya.php");
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
                        POJO_CagarBudaya w = new POJO_CagarBudaya();
                        w.setId(jsonArray.getJSONObject(i).getString("id"));
                        w.setKelurahan(jsonArray.getJSONObject(i).getString("kelurahan"));
                        w.setNama_bangunan(jsonArray.getJSONObject(i).getString("nama_bangunan"));
                        w.setGolongan(jsonArray.getJSONObject(i).getString("gol"));
                        w.setKecamatan(jsonArray.getJSONObject(i).getString("kecamatan"));
                        w.setAlamat(jsonArray.getJSONObject(i).getString("alamat"));
                        w.setKelurahan(jsonArray.getJSONObject(i).getString("kelurahan"));
                        w.setNomor_sk(jsonArray.getJSONObject(i).getString("nomor_sk"));
                        w.setTahun_sk(jsonArray.getJSONObject(i).getString("tahun_sk"));
                        w.setKepemilikan(jsonArray.getJSONObject(i).getString("kepemilikan"));
                        w.setKondisi(jsonArray.getJSONObject(i).getString("kondisi"));
                        w.setKeterangan(jsonArray.getJSONObject(i).getString("keterangan"));
                        pojo_cagarBudayas.add(w);
                    }
                    rclKonten.setAdapter(new AdapterCagarBudaya(pojo_cagarBudayas, this));
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
}
