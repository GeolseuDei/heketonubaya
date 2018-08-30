package com.example.heketonubaya;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityHistory extends AppCompatActivity {

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

        LinearLayout layoutPending, layoutUsing, layoutHistory;

        //region Linear layout layout pending
        layoutPending = findViewById(R.id.layout_pending);
        layoutPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("PENDING");
            }
        });
        //endregion

        //region Linear layout layut using
        layoutUsing = findViewById(R.id.layout_using);
        layoutUsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("USING");
            }
        });
        //endregion

        //region Linear layout layout history
        layoutHistory = findViewById(R.id.layout_history);
        layoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("HISTORY");
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
}
