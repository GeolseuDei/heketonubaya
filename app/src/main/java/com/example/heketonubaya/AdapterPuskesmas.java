package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AdapterPuskesmas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Puskesmas> pojo_puskesmas;

    public AdapterPuskesmas(ArrayList<POJO_Puskesmas> pojo_puskesmas){
        this.pojo_puskesmas = pojo_puskesmas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_puskesmas, parent, false);
        final RecyclerView.ViewHolder mViewHolder = new RecyclerView.ViewHolder(v) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pojo_puskesmas.size();
    }
}
