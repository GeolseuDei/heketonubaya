package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterFasilitasOlahraga extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_FasilitasOlahraga> pojo_fasilitasOlahragas;

    public AdapterFasilitasOlahraga(ArrayList<POJO_FasilitasOlahraga> pojo_fasilitasOlahragas){
        this.pojo_fasilitasOlahragas = pojo_fasilitasOlahragas;
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
        return 0;
    }
}
