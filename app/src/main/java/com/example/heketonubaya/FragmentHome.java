package com.example.heketonubaya;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    public FragmentHome() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
        }

        //region Button WIrausaha
        Button btnWirausaha = view.findViewById(R.id.btnWirausaha);
        btnWirausaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityWirausaha.class);
                startActivity(intent);
            }
        });
        //endregion



        return view;
    }

}
