package com.example.projetobank.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    private Login login;


    public LoginResponse(int code, String message, Login login) {
        this.code = code;
        this.message = message;
        this.login = login;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Login getLogin(){ return  login;}


}
