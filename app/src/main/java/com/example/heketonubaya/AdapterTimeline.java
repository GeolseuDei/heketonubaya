package com.example.heketonubaya;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterTimeline extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Timeline> pojo_timelines;
    Context context;

    public AdapterTimeline(ArrayList<POJO_Timeline> pojo_timelines, Context context){
        this.pojo_timelines = pojo_timelines;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_timeline, parent, false);
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
        return pojo_timelines.size();
    }
}
