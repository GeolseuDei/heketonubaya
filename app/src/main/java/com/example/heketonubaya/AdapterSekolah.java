package com.example.heketonubaya;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterSekolah extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Sekolah> pojo_sekolahs;
    Context context;

    public AdapterSekolah(ArrayList<POJO_Sekolah> pojo_sekolahs, Context context){
        this.pojo_sekolahs = pojo_sekolahs;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sekolah, parent, false);
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
        final POJO_Sekolah pojo_sekolah = pojo_sekolahs.get(position);

        //region Constraint Root
        CardView cardView = holder.itemView.findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
                intent.putExtra("id", pojo_sekolah.getNpsn());
                context.startActivity(intent);
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return pojo_sekolahs.size();
    }
}
