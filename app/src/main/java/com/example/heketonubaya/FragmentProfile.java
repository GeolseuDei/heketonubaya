package com.example.heketonubaya;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {


    public FragmentProfile() {
        // Required empty public constructor
    }

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_profile, container, false);

            LinearLayout layoutEditProfile, layoutHistory, layoutFAQ, layoutContactUs;
            layoutEditProfile = view.findViewById(R.id.layout_editprofile);

            //region Linear layout layout history
            layoutHistory = view.findViewById(R.id.layout_history);
            layoutHistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), ActivityHistory.class));
                }
            });
            //endregion

            //region Linear layout FAQ
            layoutFAQ = view.findViewById(R.id.layout_faq);
            layoutFAQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), ActivityFaq.class));
                }
            });
            //endregion

            //region Linear Layout contact us
            layoutContactUs = view.findViewById(R.id.layout_contactus);
            layoutContactUs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), ActivityContactUs.class));
                }
            });
            //endregion
        }
        return view;
    }

}