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
        POJO_Timeline p1, p2, p3, p4;
        p1 = new POJO_Timeline();
        p2 = new POJO_Timeline();
        p3 = new POJO_Timeline();
        p4 = new POJO_Timeline();

        p1.setPenanggung_jawab("John Doe");
        p1.setInstance("Fasilitas Olahraga");
        p1.setFoto("fasilitas_olahraga");
        p1.setKeterangan("Dalam menyambut hari kemerdekaan RI Lapangan X memberikan diskon 70% bagi yang menggunakan fasilitas mulai tanggal 1 agustus - 31 agustus. Silahkan datang ke tempat kami di jl. XYZ");

        p2.setPenanggung_jawab("John Doe");
        p2.setInstance("Puskesmas");
        p2.setFoto("puskesmas");
        p2.setKeterangan("Puskesmas X akan tutup mulai tanggal 10 april 2018 hingga 20 april 2018 dikarenakan staff dan pekerja akan diikutsertakan dalam penanggulangan bencana gempa di wilayah X");

        p3.setPenanggung_jawab("John Doe");
        p3.setInstance("Cagar Budaya");
        p3.setFoto("cagar_budaya");
        p3.setKeterangan("Gratis masuk ke Cagar Budaya X mulai tanggal 10 mei 2018 - 30 mei 2018. Silahkan ajak teman, keluarga, dan kerabat anda mengunjungi Cagar Budaya X.");

        p4.setPenanggung_jawab("John Doe");
        p4.setInstance("Sekolah");
        p4.setFoto("sekolah");
        p4.setKeterangan("Sekolah X mengadakan bakti sosial untuk menyumbang korban bencana alam di daerah X. Bagi yang berminat menyumbang bisa menghubungi kontak yang ada di poster terima kasih.");

        pojo_timelines.add(p1);
        pojo_timelines.add(p2);
        pojo_timelines.add(p3);
        pojo_timelines.add(p4);

        recyclerView.setAdapter(new AdapterTimeline(pojo_timelines, getActivity()));
    }
}
