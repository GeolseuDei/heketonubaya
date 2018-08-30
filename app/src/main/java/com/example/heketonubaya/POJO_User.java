package com.example.heketonubaya;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO_User implements Parcelable {
    private String id;
    private String username;
    private String password;
    private String role;
    private String foto;
    private String token;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.role);
        dest.writeString(this.foto);
        dest.writeString(this.token);
        dest.writeString(this.status);
    }

    public POJO_User() {
    }

    protected POJO_User(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.password = in.readString();
        this.role = in.readString();
        this.foto = in.readString();
        this.token = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<POJO_User> CREATOR = new Parcelable.Creator<POJO_User>() {
        @Override
        public POJO_User createFromParcel(Parcel source) {
            return new POJO_User(source);
        }

        @Override
        public POJO_User[] newArray(int size) {
            return new POJO_User[size];
        }
    };
}
