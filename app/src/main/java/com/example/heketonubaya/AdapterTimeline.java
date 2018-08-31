package com.example.heketonubaya;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        TextView textView = holder.itemView.findViewById(R.id.tv_penanggung_jawab);
        TextView textView1 = holder.itemView.findViewById(R.id.tv_instance);
        TextView textView2 = holder.itemView.findViewById(R.id.tv_keterangan);
        ImageView imageView = holder.itemView.findViewById(R.id.iv_timeline);

        textView.setText(pojo_timelines.get(position).getPenanggung_jawab());
        textView1.setText(pojo_timelines.get(position).getInstance());
        textView2.setText(pojo_timelines.get(position).getKeterangan());

        if(pojo_timelines.get(position).getFoto().equals("fasilitas_olahraga")) {
            Glide.with(context).load(R.drawable.lapangan).into(imageView);
        }
        if(pojo_timelines.get(position).getFoto().equals("puskesmas")) {
            Glide.with(context).load(R.drawable.fotopuskesmas).into(imageView);
        }
        if(pojo_timelines.get(position).getFoto().equals("cagar_budaya")) {
            Glide.with(context).load(R.drawable.monumen).into(imageView);
        }
        if(pojo_timelines.get(position).getFoto().equals("sekolah")) {
            Glide.with(context).load(R.drawable.fotosekolah).into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return pojo_timelines.size();
    }
}
