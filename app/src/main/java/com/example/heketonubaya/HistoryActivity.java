package com.example.heketonubaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setTitle("PENDING");

        LinearLayout layoutPending, layoutUsing, layoutHistory;
        layoutPending = findViewById(R.id.layout_pending);
        layoutUsing = findViewById(R.id.layout_using);
        layoutHistory = findViewById(R.id.layout_history);

        layoutPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("PENDING");
            }
        });

        layoutUsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("USING");
            }
        });

        layoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("HISTORY");
            }
        });
    }
}
