package com.example.projetobank;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projetobank.model.Login;

public class SharedPrefManager {

    private SharedPreferences sharedPreferences;
    private Context context;
    private int itsSave = 0;
    private String user;

    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        getSharedPreferences();
    }

    public int getItsSave() {
        return itsSave;
    }

    public String getUser() {
        return user;
    }

    public void saveLogin(String user){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", user);
        editor.putInt("itsSave", 1);

        this.getSharedPreferences();
    }
    private void getSharedPreferences() {
        this.itsSave = sharedPreferences.getInt("itsSave", 0);
        this.user = sharedPreferences.getString("user", "");
    }


}
