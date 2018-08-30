package com.example.heketonubaya;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterFasilitasOlahraga extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_FasilitasOlahraga> pojo_fasilitasOlahragas;
    Context context;

    public AdapterFasilitasOlahraga(ArrayList<POJO_FasilitasOlahraga> pojo_fasilitasOlahragas, Context context){
        this.pojo_fasilitasOlahragas = pojo_fasilitasOlahragas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_olahraga, parent, false);
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
        final POJO_FasilitasOlahraga pojo_fasilitasOlahraga = pojo_fasilitasOlahragas.get(position);

        //region Constraint Root
        ConstraintLayout cnsView = holder.itemView.findViewById(R.id.cnsView);
        cnsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
                intent.putExtra("id", pojo_fasilitasOlahraga.getId());
                context.startActivity(intent);
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return pojo_fasilitasOlahragas.size();
    }
}
