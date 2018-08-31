package com.example.heketonubaya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AdapterReviewPendaftaran extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_ReviewPendaftaran> pojo_reviewPendaftarans;
    Context context;

    public AdapterReviewPendaftaran ( ArrayList<POJO_ReviewPendaftaran> pojo_reviewPendaftarans, Context context){
        this.pojo_reviewPendaftarans = pojo_reviewPendaftarans;
        this.context = context;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review_pendaftaran, parent, false);
        final RecyclerView.ViewHolder mViewHolder = new RecyclerView.ViewHolder(v) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return pojo_reviewPendaftarans.size();
    }
}
