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

public class ActivityFasilitasOlahraga extends AppCompatActivity {

    ArrayList<POJO_FasilitasOlahraga> pojo_fasilitasOlahragas;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas_olahraga);

        StrictMode.ThreadPolicy policy;
        policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setTitle("Fasilitas Olahraga");

        pojo_fasilitasOlahragas = new ArrayList<>();

        //region Recyclerview Konten
        RecyclerView rclKonten = findViewById(R.id.rclKonten);
        rclKonten.setLayoutManager(new LinearLayoutManager(this));

        //endregion

        HttpURLConnection conn = null;
        URL url = null;
        try {
            url = new URL(new TargetAPI().getTarget_url() + "fasilitas_olahraga.php");
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
                        POJO_FasilitasOlahraga w = new POJO_FasilitasOlahraga();
                        w.setId(jsonArray.getJSONObject(i).getString("id"));
                        w.setKelurahan(jsonArray.getJSONObject(i).getString("kelurahan"));
                        w.setNama_prasarana(jsonArray.getJSONObject(i).getString("nama_prasarana"));
                        w.setJenis_prasarana_olahraga(jsonArray.getJSONObject(i).getString("jenis_prasarana_olahraga"));
                        w.setKecamatan(jsonArray.getJSONObject(i).getString("kecamatan"));
                        w.setAlamat(jsonArray.getJSONObject(i).getString("alamat"));
                        w.setBidang_olahraga(jsonArray.getJSONObject(i).getString("bidang_olahraga"));
                        w.setKondisi_prasarana(jsonArray.getJSONObject(i).getString("kondisi_prasarana"));
                        w.setTahun_dibangun(jsonArray.getJSONObject(i).getString("tahun_dibangun"));
                        w.setTahun_rehabilitasi(jsonArray.getJSONObject(i).getString("tahun_rehabilitasi"));
                        w.setLuas(jsonArray.getJSONObject(i).getString("luas"));
                        pojo_fasilitasOlahragas.add(w);
                    }
                    rclKonten.setAdapter(new AdapterFasilitasOlahraga(pojo_fasilitasOlahragas, this));
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
