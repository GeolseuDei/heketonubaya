package com.example.heketonubaya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
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

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

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
//        CardView cardView = holder.itemView.findViewById(R.id.card_view);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
//                intent.putExtra("id", pojo_fasilitasOlahraga.getId());
//                context.startActivity(intent);
//            }
//        });
        //endregion

        TextView textView = holder.itemView.findViewById(R.id.tv_nama);
        TextView textView1 = holder.itemView.findViewById(R.id.tv_alamat);
        TextView textView2 = holder.itemView.findViewById(R.id.tv_luas);
        final ImageView imageView = holder.itemView.findViewById(R.id.img_item_photo);

        textView.setText(pojo_fasilitasOlahraga.getNama_prasarana());
        textView1.setText(pojo_fasilitasOlahraga.getAlamat());
//        textView2.setText(pojo_fasilitasOlahraga.getLuas() + " meter");
        textView2.setText("");
        Glide.with(context).load(R.drawable.lapangan).into(imageView);
        ViewCompat.setTransitionName(imageView, "image"+pojo_fasilitasOlahraga.getId());

        final Button button = holder.itemView.findViewById(R.id.btn_details);
        button.setTransitionName("apply"+pojo_fasilitasOlahraga.getId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetailFasilitasOlahraga.class);
                intent.putExtra("pojo_fasilitas_olahraga", pojo_fasilitasOlahraga);
                intent.putExtra("transition", pojo_fasilitasOlahraga.getId());
                Pair<View, String> pair2 = Pair.create((View) imageView, imageView.getTransitionName());
                Pair<View, String> pair3 = Pair.create((View) button, button.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation((Activity) context, pair2,pair3);
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojo_fasilitasOlahragas.size();
    }
}
