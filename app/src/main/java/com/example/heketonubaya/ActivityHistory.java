package com.example.heketonubaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

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
}
