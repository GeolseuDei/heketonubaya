package com.example.heketonubaya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPending extends Fragment {


    public FragmentPending() {
        // Required empty public constructor
    }

    View view;
    RecyclerView recyclerView;
    ArrayList<String> strings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_pending, container, false);

//            recyclerView = view.findViewById(R.id.rclKonten);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//            strings = new ArrayList<>();
//
//            for (int i = 0; i < 5; i++) {
//                strings.add("");
//            }
//
//            recyclerView.setAdapter(new AdapterPending(strings, getActivity()));
        }
        return view;
    }

}
