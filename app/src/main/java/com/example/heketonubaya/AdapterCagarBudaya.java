package com.example.heketonubaya;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterCagarBudaya extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_CagarBudaya> pojo_cagarBudayas;
    Context context;

    public AdapterCagarBudaya(ArrayList<POJO_CagarBudaya> pojo_cagarBudayas, Context context){
        this.pojo_cagarBudayas = pojo_cagarBudayas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cagar_budaya, parent, false);
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
        final POJO_CagarBudaya pojo_cagarBudaya = pojo_cagarBudayas.get(position);

        //region Constraint Root
        ConstraintLayout cnsView = holder.itemView.findViewById(R.id.cnsView);
        cnsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
                intent.putExtra("id", pojo_cagarBudaya.getId());
                context.startActivity(intent);
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return pojo_cagarBudayas.size();
    }
}
