package com.example.heketonubaya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterReviewPendaftaran extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<POJO_ReviewPendaftaran> pojo_reviewPendaftarans;
    Context context;

    public AdapterReviewPendaftaran(ArrayList<POJO_ReviewPendaftaran> pojo_reviewPendaftarans, Context context) {
        this.pojo_reviewPendaftarans = pojo_reviewPendaftarans;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review_pendaftaran, parent, false);
        final RecyclerView.ViewHolder mViewHolder = new RecyclerView.ViewHolder(v) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        View view = holder.itemView;
        POJO_ReviewPendaftaran pojo_reviewPendaftaran = pojo_reviewPendaftarans.get(position);

        ImageView imgBuktiPendaftaran = view.findViewById(R.id.imgBuktiPendaftaran);
        switch (pojo_reviewPendaftaran.getBukti()) {
            case "surat_pkm.png":
                imgBuktiPendaftaran.setImageResource(R.drawable.surat_pkm);
                break;
            case "surat_wiraswasta.jpg":
                imgBuktiPendaftaran.setImageResource(R.drawable.surat_wiraswasta);
                break;
            case "surat_wiraswasta2.jpg":
                imgBuktiPendaftaran.setImageResource(R.drawable.surat_wiraswasta2);
                break;
        }

        TextView tv_keterangan = view.findViewById(R.id.tv_keterangan);
        tv_keterangan.setText("nama : "+pojo_reviewPendaftaran.getNama()+"\nJenis : "+pojo_reviewPendaftaran.getJenis()+"\nalamat : "+pojo_reviewPendaftaran.getAlamat()+"\ntelepon : "+pojo_reviewPendaftaran.getTelepon()+"\n\nDeskripsi : \n"+pojo_reviewPendaftaran.getDeskripsi());

        Button btnTerima, btnTolak;
        btnTerima = view.findViewById(R.id.btnTerima);
        btnTolak = view.findViewById(R.id.btnTolak);
        btnTerima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });
        btnTolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });

    }

    public void removeItem(int position){
        pojo_reviewPendaftarans.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, pojo_reviewPendaftarans);
    }

    @Override
    public int getItemCount() {
        return pojo_reviewPendaftarans.size();
    }
}
