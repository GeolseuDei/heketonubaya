package com.example.heketonubaya;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO_FasilitasOlahraga implements Parcelable {
    private String id;
    private String nama_prasarana;
    private String jenis_prasarana_olahraga;
    private String bidang_olahraga;
    private String kecamatan;
    private String kelurahan;
    private String alamat;
    private String kondisi_prasarana;
    private String tahun_dibangun;
    private String tahun_rehabilitasi;
    private String luas;
    private String user_id;

    public POJO_FasilitasOlahraga() {
    }

    protected POJO_FasilitasOlahraga(Parcel in) {
        id = in.readString();
        nama_prasarana = in.readString();
        jenis_prasarana_olahraga = in.readString();
        bidang_olahraga = in.readString();
        kecamatan = in.readString();
        kelurahan = in.readString();
        alamat = in.readString();
        kondisi_prasarana = in.readString();
        tahun_dibangun = in.readString();
        tahun_rehabilitasi = in.readString();
        luas = in.readString();
        user_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama_prasarana);
        dest.writeString(jenis_prasarana_olahraga);
        dest.writeString(bidang_olahraga);
        dest.writeString(kecamatan);
        dest.writeString(kelurahan);
        dest.writeString(alamat);
        dest.writeString(kondisi_prasarana);
        dest.writeString(tahun_dibangun);
        dest.writeString(tahun_rehabilitasi);
        dest.writeString(luas);
        dest.writeString(user_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<POJO_FasilitasOlahraga> CREATOR = new Creator<POJO_FasilitasOlahraga>() {
        @Override
        public POJO_FasilitasOlahraga createFromParcel(Parcel in) {
            return new POJO_FasilitasOlahraga(in);
        }

        @Override
        public POJO_FasilitasOlahraga[] newArray(int size) {
            return new POJO_FasilitasOlahraga[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_prasarana() {
        return nama_prasarana;
    }

    public void setNama_prasarana(String nama_prasarana) {
        this.nama_prasarana = nama_prasarana;
    }

    public String getJenis_prasarana_olahraga() {
        return jenis_prasarana_olahraga;
    }

    public void setJenis_prasarana_olahraga(String jenis_prasarana_olahraga) {
        this.jenis_prasarana_olahraga = jenis_prasarana_olahraga;
    }

    public String getBidang_olahraga() {
        return bidang_olahraga;
    }

    public void setBidang_olahraga(String bidang_olahraga) {
        this.bidang_olahraga = bidang_olahraga;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKondisi_prasarana() {
        return kondisi_prasarana;
    }

    public void setKondisi_prasarana(String kondisi_prasarana) {
        this.kondisi_prasarana = kondisi_prasarana;
    }

    public String getTahun_dibangun() {
        return tahun_dibangun;
    }

    public void setTahun_dibangun(String tahun_dibangun) {
        this.tahun_dibangun = tahun_dibangun;
    }

    public String getTahun_rehabilitasi() {
        return tahun_rehabilitasi;
    }

    public void setTahun_rehabilitasi(String tahun_rehabilitasi) {
        this.tahun_rehabilitasi = tahun_rehabilitasi;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
