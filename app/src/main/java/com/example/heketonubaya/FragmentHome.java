package com.example.heketonubaya;


import android.content.Context;
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

        //region Button Puskesmas
        Button btnPuskesmas = view.findViewById(R.id.btnPuskesmas);
        btnPuskesmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityPuskesmas.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Button PMK
        Button btnPmk = view.findViewById(R.id.btnPmk);
        btnPmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityPmk.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Button Koperasi
        Button btnKoperasi = view.findViewById(R.id.btnKoperasi);
        btnKoperasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityKoperasi.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Button Sekolah
        Button btnSekolah = view.findViewById(R.id.btnSekolah);
        btnSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivitySekolah.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Button Fasilitas Olahraga
        Button btnOlahraga = view.findViewById(R.id.btnOlahraga);
        btnOlahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityFasilitasOlahraga.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Button Cagar Budaya
        Button btnCagarBudaya = view.findViewById(R.id.btnCagar);
        btnCagarBudaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityCagarBudaya.class);
                startActivity(intent);
            }
        });
        //endregion

        return view;
    }

}
