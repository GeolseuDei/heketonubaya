package com.example.heketonubaya;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ActivityHistory extends AppCompatActivity {

    FragmentTransaction ft;
    RecyclerView recyclerView;
    ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle("PENDING");
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.historyFrame, new FragmentPending());
        ft.commit();

        LinearLayout layoutPending, layoutHistory;

        //region Linear layout layout pending
        layoutPending = findViewById(R.id.layout_pending);
        layoutPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("PENDING");
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.historyFrame, new FragmentPending());
                ft.commit();
            }
        });
        //endregion

        //region Linear layout layout history
        layoutHistory = findViewById(R.id.layout_history);
        layoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("HISTORY");
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.historyFrame, new FragmentPending());
                ft.commit();
            }
        });
        //endregion

//        recyclerView = findViewById(R.id.rclKonten);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//
//        strings = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            strings.add("");
//        }
//
//        recyclerView.setAdapter(new AdapterPending(strings, getApplicationContext()));
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
