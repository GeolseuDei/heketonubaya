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

        POJO_Request p1, p2, p3, p4;
        p1 = new POJO_Request();
        p2 = new POJO_Request();
        p3 = new POJO_Request();
        p4 = new POJO_Request();

        p1.setTitle("Acara Donor Darah");
        p1.setFrom("Sekolah X");
        p1.setDate_req("12-12-2018");
        p1.setContent("Selamat siang, kami dari sekolah X dalam rangka memperingati hari pahlawan akan mengadakan acara donor darah pada tanggal 2019-12-12 yang diadakan di halaman sekolah X. Oleh karena itu kami ingin mengajak kerjasama dengan puskesmas terkait agar acara ini dapat berjalan dengan lancar. Kami lampirkan juga file permohonan pengajuan kerjasama untuk sebagai pertimbangan. Atas perhatiannya saya ucapkan terima kasih.");

        p2.setTitle("Acara Seminar Kewirausahaan");
        p2.setFrom("Sekolah X");
        p2.setDate_req("12-12-2018");
        p2.setContent("Selamat pagi, kami dari sekolah X ingin mengajak bapak/ibu selaku penggiat wirausaha untuk menjadi pembicara dalam acara seminar mengenai industri global yang akan diadakan di sekolah kami. Acara ini diadakan pada tanggal 12-12-2019 di Gedung X. Kami lampirkan juga file permohonan pengajuan kerjasama untuk sebagai pertimbangan. Atas perhatiannya kami ucapkan terima kasih.");

        p3.setTitle("Studi Tour Sekolah X");
        p3.setFrom("Sekolah X");
        p3.setDate_req("12-12-2018");
        p3.setContent("Selamat pagi, kami dari sekolah X ingin melakukan studi tour ke tempat cagar budaya milik bapak/ibu pada tanggal 12-12-2019. Mengenai hal tersebut kami lampirkan proposal dan jadwal kegiatan yang akan dilakukan di cagar budaya tersebut.");

        p4.setTitle("Permohonan Peminjaman Fasilitas Olahraga");
        p4.setFrom("Sekolah X");
        p4.setDate_req("12-12-2018");
        p4.setContent("Selamat siang, kami dari sekolah X dalam menyambut pekan olahraga ASIAN GAMES ingin mengadakan perlombaan bidang olahraga untuk guru dan murid sekolah X. Mengenai hal tersebut kami ingin meminjam beberapa alat dan fasilitas milik bapak/ibu untuk digunakan pada tanggal 2019-12-12. Kami lampirkan juga file proposal dan detail fasilitas yang akan dipinjam. Atas perhatiannya kami ucapkan terima kasih.");


        pojo_requests.add(p1);
        pojo_requests.add(p2);
        pojo_requests.add(p3);
        pojo_requests.add(p4);

        recyclerView.setAdapter(new AdapterRequest(pojo_requests, getActivity()));
    }
}
