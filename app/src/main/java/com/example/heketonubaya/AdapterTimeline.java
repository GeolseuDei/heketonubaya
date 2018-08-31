package com.example.heketonubaya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class AdapterTimeline extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Timeline> pojo_timelines;
    Context context;

    public AdapterTimeline(ArrayList<POJO_Timeline> pojo_timelines, Context context) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        TextView textView = holder.itemView.findViewById(R.id.tv_penanggung_jawab);
        TextView textView1 = holder.itemView.findViewById(R.id.tv_instance);
        TextView textView2 = holder.itemView.findViewById(R.id.tv_keterangan);
        final ImageView imageView = holder.itemView.findViewById(R.id.iv_timeline);

        textView.setText(pojo_timelines.get(position).getPenanggung_jawab());
        textView1.setText(pojo_timelines.get(position).getInstance());
        textView2.setText(pojo_timelines.get(position).getKeterangan());

        final int id;
        if (pojo_timelines.get(position).getFoto().equals("fasilitas_olahraga")) {
            id = R.drawable.lapangan;
        } else if (pojo_timelines.get(position).getFoto().equals("puskesmas")) {
            id = R.drawable.fotopuskesmas;
        } else if (pojo_timelines.get(position).getFoto().equals("cagar_budaya")) {
            id = R.drawable.monumen;
        } else if (pojo_timelines.get(position).getFoto().equals("sekolah")) {
            id = R.drawable.fotosekolah;
        } else {
            id = R.drawable.lapangan;
        }

        Glide.with(context).load(id).into(imageView);

        imageView.setTransitionName("image" + pojo_timelines.get(position).getId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetailGambar.class);
                intent.putExtra("id", id);
                intent.putExtra("transition", pojo_timelines.get(position).getId());
                Pair<View, String> pair1 = Pair.create((View) imageView, imageView.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation((Activity) context, pair1);
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojo_timelines.size();
    }
}
