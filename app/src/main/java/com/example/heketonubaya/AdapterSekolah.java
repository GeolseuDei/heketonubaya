package com.example.heketonubaya;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
//        CardView cardView = holder.itemView.findViewById(R.id.card_view);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
//                intent.putExtra("id", pojo_sekolah.getNpsn());
//                context.startActivity(intent);
//            }
//        });

        TextView textView = holder.itemView.findViewById(R.id.tv_nama);
        TextView textView1 = holder.itemView.findViewById(R.id.tv_alamat);
        TextView textView2 = holder.itemView.findViewById(R.id.tv_status);

        textView.setText(pojo_sekolah.getNama());
        textView1.setText(pojo_sekolah.getAlamat());
        textView2.setText(pojo_sekolah.getStatus().equals("N") ? "Negeri" : "Swasta");

        ImageView imageView = holder.itemView.findViewById(R.id.img_item_photo);
        Glide.with(context).load(R.drawable.fotosekolah).into(imageView);

        Button button = holder.itemView.findViewById(R.id.btn_details);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetailSekolah.class);
                intent.putExtra("pojo_sekolah", pojo_sekolah);
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
