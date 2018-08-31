package com.example.heketonubaya;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO_Wirausaha implements Parcelable {
    private String id;
    private String nama_kupp;
    private String penanggungjawab;
    private String jenis_kelamin;
    private String kecamatan;
    private String alamat;
    private String telepon;
    private String jenis_usaha;
    private String nik;
    private String user_id;

    public POJO_Wirausaha() {
    }

    protected POJO_Wirausaha(Parcel in) {
        id = in.readString();
        nama_kupp = in.readString();
        penanggungjawab = in.readString();
        jenis_kelamin = in.readString();
        kecamatan = in.readString();
        alamat = in.readString();
        telepon = in.readString();
        jenis_usaha = in.readString();
        nik = in.readString();
        user_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama_kupp);
        dest.writeString(penanggungjawab);
        dest.writeString(jenis_kelamin);
        dest.writeString(kecamatan);
        dest.writeString(alamat);
        dest.writeString(telepon);
        dest.writeString(jenis_usaha);
        dest.writeString(nik);
        dest.writeString(user_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<POJO_Wirausaha> CREATOR = new Creator<POJO_Wirausaha>() {
        @Override
        public POJO_Wirausaha createFromParcel(Parcel in) {
            return new POJO_Wirausaha(in);
        }

        @Override
        public POJO_Wirausaha[] newArray(int size) {
            return new POJO_Wirausaha[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_kupp() {
        return nama_kupp;
    }

    public void setNama_kupp(String nama_kupp) {
        this.nama_kupp = nama_kupp;
    }

    public String getPenanggungjawab() {
        return penanggungjawab;
    }

    public void setPenanggungjawab(String penanggungjawab) {
        this.penanggungjawab = penanggungjawab;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJenis_usaha() {
        return jenis_usaha;
    }

    public void setJenis_usaha(String jenis_usaha) {
        this.jenis_usaha = jenis_usaha;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
