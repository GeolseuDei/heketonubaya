package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterSekolah extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Sekolah> pojo_sekolahs;

    public AdapterSekolah(ArrayList<POJO_Sekolah> pojo_sekolahs){
        this.pojo_sekolahs = pojo_sekolahs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pojo_sekolahs.size();
    }
}