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

public class AdapterWirausaha extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_Wirausaha> pojo_wirausahas;
    Context context;

    public AdapterWirausaha(ArrayList<POJO_Wirausaha> pojo_wirausahas, Context context){
        this.pojo_wirausahas = pojo_wirausahas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_wirausaha, parent, false);
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

        final POJO_Wirausaha pojo_wirausaha = pojo_wirausahas.get(position);

        //region Constraint Root
//        CardView cardView = holder.itemView.findViewById(R.id.card_view);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
//                intent.putExtra("id", pojo_wirausaha.getId());
//                context.startActivity(intent);
//            }
//        });

        ImageView imageView = holder.itemView.findViewById(R.id.img_item_photo);
        Glide.with(context).load(R.mipmap.ic_launcher).into(imageView);

        TextView textView = holder.itemView.findViewById(R.id.tv_nama);
        textView.setText(pojo_wirausaha.getNama_kupp());

        TextView textView1 = holder.itemView.findViewById(R.id.tv_alamat);
        textView1.setText(pojo_wirausaha.getAlamat());

        TextView textView2 = holder.itemView.findViewById(R.id.tv_jenis_usaha);
        textView2.setText(pojo_wirausaha.getJenis_usaha());

        Button button = holder.itemView.findViewById(R.id.btn_details);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
                intent.putExtra("id", pojo_wirausaha.getId());
                context.startActivity(intent);
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return pojo_wirausahas.size();
    }
}
