package com.example.projetobank.login;

import com.example.projetobank.model.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    private User user;

    public LoginResponse(int code, String message, User user) {
        this.code = code;
        this.message = message;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public User getUser(){ return  user;}


}
