package com.example.heketonubaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityWirausaha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wirausaha);

        //region isi class
        POJO_Wirausaha pojo_wirausaha = new POJO_Wirausaha();
        pojo_wirausaha.setId("1");
        pojo_wirausaha.setNama_kupp("nama kupp");
        pojo_wirausaha.setJenis_kelamin("laki");
        //endregion

        //region isi arraylist
        ArrayList<POJO_Wirausaha> pojo_wirausahas = new ArrayList<>();
        pojo_wirausahas.add(pojo_wirausaha);
        //endregion

        //region Recyclerview Konten
        RecyclerView rclKonten = findViewById(R.id.rclKonten);
        rclKonten.setLayoutManager(new LinearLayoutManager(this));
        rclKonten.setAdapter(new AdapterWirausaha(pojo_wirausahas, this));
        //endregion
    }
}
