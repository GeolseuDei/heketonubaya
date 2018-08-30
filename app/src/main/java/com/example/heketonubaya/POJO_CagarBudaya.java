package com.example.heketonubaya;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO_CagarBudaya implements Parcelable {
    private String id;
    private String nama_bangunan;
    private String alamat;
    private String golongan;
    private String kelurahan;
    private String kecamatan;
    private String nomor_sk;
    private String tahun_sk;
    private String kepemilikan;
    private String kondisi;
    private String keterangan;
    private String user_id;

    public POJO_CagarBudaya() {
    }

    protected POJO_CagarBudaya(Parcel in) {
        id = in.readString();
        nama_bangunan = in.readString();
        alamat = in.readString();
        golongan = in.readString();
        kelurahan = in.readString();
        kecamatan = in.readString();
        nomor_sk = in.readString();
        tahun_sk = in.readString();
        kepemilikan = in.readString();
        kondisi = in.readString();
        keterangan = in.readString();
        user_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama_bangunan);
        dest.writeString(alamat);
        dest.writeString(golongan);
        dest.writeString(kelurahan);
        dest.writeString(kecamatan);
        dest.writeString(nomor_sk);
        dest.writeString(tahun_sk);
        dest.writeString(kepemilikan);
        dest.writeString(kondisi);
        dest.writeString(keterangan);
        dest.writeString(user_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<POJO_CagarBudaya> CREATOR = new Creator<POJO_CagarBudaya>() {
        @Override
        public POJO_CagarBudaya createFromParcel(Parcel in) {
            return new POJO_CagarBudaya(in);
        }

        @Override
        public POJO_CagarBudaya[] newArray(int size) {
            return new POJO_CagarBudaya[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_bangunan() {
        return nama_bangunan;
    }

    public void setNama_bangunan(String nama_bangunan) {
        this.nama_bangunan = nama_bangunan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNomor_sk() {
        return nomor_sk;
    }

    public void setNomor_sk(String nomor_sk) {
        this.nomor_sk = nomor_sk;
    }

    public String getTahun_sk() {
        return tahun_sk;
    }

    public void setTahun_sk(String tahun_sk) {
        this.tahun_sk = tahun_sk;
    }

    public String getKepemilikan() {
        return kepemilikan;
    }

    public void setKepemilikan(String kepemilikan) {
        this.kepemilikan = kepemilikan;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
