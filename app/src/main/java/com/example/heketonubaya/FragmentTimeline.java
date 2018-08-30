package com.example.heketonubaya;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTimeline extends Fragment {


    public FragmentTimeline() {
        // Required empty public constructor
    }

    View view;
    RecyclerView recyclerView;
    FloatingActionButton fab;

    ArrayList<POJO_Timeline> pojo_timelines;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_timeline, container, false);

            recyclerView = view.findViewById(R.id.rclKonten);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            fab = view.findViewById(R.id.fab);
            YoYo.with(Techniques.BounceInUp).duration(700).playOn(fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), ActivityWriteTimeline.class));
                }
            });
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        pojo_timelines = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pojo_timelines.add(new POJO_Timeline());
        }
        recyclerView.setAdapter(new AdapterTimeline(pojo_timelines, getActivity()));
    }
}
