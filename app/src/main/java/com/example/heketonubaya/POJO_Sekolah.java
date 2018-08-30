package com.example.heketonubaya;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO_Sekolah implements Parcelable {
    private String npsn;
    private String nama;
    private String alamat;
    private String status;
    private String jenjang;
    private String lat;
    private String lng;
    private String user_id;

    public POJO_Sekolah() {
    }

    protected POJO_Sekolah(Parcel in) {
        npsn = in.readString();
        nama = in.readString();
        alamat = in.readString();
        status = in.readString();
        jenjang = in.readString();
        lat = in.readString();
        lng = in.readString();
        user_id = in.readString();
    }

    public static final Creator<POJO_Sekolah> CREATOR = new Creator<POJO_Sekolah>() {
        @Override
        public POJO_Sekolah createFromParcel(Parcel in) {
            return new POJO_Sekolah(in);
        }

        @Override
        public POJO_Sekolah[] newArray(int size) {
            return new POJO_Sekolah[size];
        }
    };

    public String getNpsn() {
        return npsn;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(npsn);
        parcel.writeString(nama);
        parcel.writeString(alamat);
        parcel.writeString(status);
        parcel.writeString(jenjang);
        parcel.writeString(lat);
        parcel.writeString(lng);
        parcel.writeString(user_id);
    }
}
