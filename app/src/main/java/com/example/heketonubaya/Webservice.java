package com.example.heketonubaya;

public class Webservice {

    public boolean login(String username, String password, POJO_User pojo_user){
        boolean hasil = true;
        if(hasil){
            pojo_user.setId("1");
            pojo_user.setUsername("tes");
            return true;
        }else{
            return false;
        }
    }

}
