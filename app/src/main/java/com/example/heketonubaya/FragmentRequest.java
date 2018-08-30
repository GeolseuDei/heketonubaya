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
public class FragmentRequest extends Fragment {


    public FragmentRequest() {
        // Required empty public constructor
    }

    View view;
    RecyclerView recyclerView;
    ArrayList<POJO_Request> pojo_requests;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_request, container, false);

            recyclerView = view.findViewById(R.id.rclKonten);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        pojo_requests = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pojo_requests.add(new POJO_Request());
        }
        recyclerView.setAdapter(new AdapterRequest(pojo_requests, getActivity()));
    }
}
