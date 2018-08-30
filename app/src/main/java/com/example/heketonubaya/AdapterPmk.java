package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterPmk extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_PMK> pojo_pmks;

    public AdapterPmk(ArrayList<POJO_PMK> pojo_pmks){
        this.pojo_pmks = pojo_pmks;
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
        return pojo_pmks.size();
    }
}
