package com.example.heketonubaya;

public class POJO_appointment {
    private String id;
    private String judul;
    private String keterangan;
    private String tanggal;
    private String user_id_pemohon;
    private String user_id_penerima;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUser_id_pemohon() {
        return user_id_pemohon;
    }

    public void setUser_id_pemohon(String user_id_pemohon) {
        this.user_id_pemohon = user_id_pemohon;
    }

    public String getUser_id_penerima() {
        return user_id_penerima;
    }

    public void setUser_id_penerima(String user_id_penerima) {
        this.user_id_penerima = user_id_penerima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
