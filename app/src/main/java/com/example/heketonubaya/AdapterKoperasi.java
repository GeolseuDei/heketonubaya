package com.example.heketonubaya;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterKoperasi extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<POJO_Koperasi> pojo_koperasis;

    public AdapterKoperasi(ArrayList<POJO_Koperasi> pojo_koperasis, Context context){
        this.context = context;
        this.pojo_koperasis = pojo_koperasis;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_koperasi, parent, false);
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
        return 0;
    }
}
