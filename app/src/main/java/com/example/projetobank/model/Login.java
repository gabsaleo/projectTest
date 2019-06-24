package com.example.projetobank.model;

import android.content.Context;

public class Login {

    private String user;
    private long userId;
    private Context context;

    public long getUserId() {
        return userId;
    }

    public String getUser(){ return user;}

    public Login(long userId, String user) {
        this.userId = userId;
        this.user = user;
    }
}




