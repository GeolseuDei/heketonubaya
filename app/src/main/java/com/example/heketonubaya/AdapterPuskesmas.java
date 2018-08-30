package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AdapterPuskesmas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Puskesmas> pojo_puskesmas;

    public AdapterPuskesmas(ArrayList<POJO_Puskesmas> pojo_puskesmas){
        this.pojo_puskesmas = pojo_puskesmas;
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
        return pojo_puskesmas.size();
    }
}
