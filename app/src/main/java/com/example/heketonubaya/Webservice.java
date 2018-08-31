package com.example.heketonubaya;

public class Webservice {

    public boolean login(String username, String password, POJO_User pojo_user){
        boolean hasil = true;
        if(hasil){
            pojo_user.setId("1");
            pojo_user.setUsername("AU TO WIN");
            return true;
        }else{
            return false;
        }
    }

    public boolean register(String username, String password, String foto, String legalitas, String nama, String alamat, String telpon){
        boolean hasil = true;
        if(hasil){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateNamaProfil(String nama, String id){
        boolean hasil = true;
        if(hasil){
            return true;
        }else{
            return false;
        }
    }

}
