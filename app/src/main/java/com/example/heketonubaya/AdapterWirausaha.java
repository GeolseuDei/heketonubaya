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

        final ImageView imageView = holder.itemView.findViewById(R.id.img_item_photo);
        Glide.with(context).load(R.drawable.fototoko).into(imageView);

        final TextView textView = holder.itemView.findViewById(R.id.tv_nama);
        textView.setText(pojo_wirausaha.getNama_kupp());

        TextView textView1 = holder.itemView.findViewById(R.id.tv_alamat);
        textView1.setText(pojo_wirausaha.getAlamat());

        TextView textView2 = holder.itemView.findViewById(R.id.tv_jenis_usaha);
        textView2.setText(pojo_wirausaha.getJenis_usaha());

        ViewCompat.setTransitionName(textView, pojo_wirausaha.getNama_kupp());
        ViewCompat.setTransitionName(imageView, "image"+pojo_wirausaha.getNama_kupp());

        final Button button = holder.itemView.findViewById(R.id.btn_details);
        button.setTransitionName("apply"+pojo_wirausaha.getNama_kupp());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetailWirausaha.class);
                intent.putExtra("pojo_wirausaha", pojo_wirausaha);
                intent.putExtra("transition_name", pojo_wirausaha.getNama_kupp());
                Pair<View, String> pair1 = Pair.create((View) textView, textView.getTransitionName());
                Pair<View, String> pair2 = Pair.create((View) imageView, imageView.getTransitionName());
                Pair<View, String> pair3 = Pair.create((View) button, button.getTransitionName());
                ActivityOptionsCompat options = makeSceneTransitionAnimation((Activity) context, pair1, pair2, pair3);
                context.startActivity(intent, options.toBundle());
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return pojo_wirausahas.size();
    }
}
