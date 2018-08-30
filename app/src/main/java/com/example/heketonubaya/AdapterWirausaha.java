package com.example.heketonubaya;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterWirausaha extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Wirausaha> pojo_wirausahas;

    public AdapterWirausaha(ArrayList<POJO_Wirausaha> pojo_wirausahas){
        this.pojo_wirausahas = pojo_wirausahas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //MARK : obj
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_wirausaha, parent, false);
        final RecyclerView.ViewHolder mViewHolder = new RecyclerView.ViewHolder(v) {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        //MARK : operation
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pojo_wirausahas.size();
    }
}
