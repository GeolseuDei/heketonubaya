package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterCagarBudaya extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_CagarBudaya> pojo_cagarBudayas;

    public AdapterCagarBudaya(ArrayList<POJO_CagarBudaya> pojo_cagarBudayas){
        this.pojo_cagarBudayas = pojo_cagarBudayas;
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
