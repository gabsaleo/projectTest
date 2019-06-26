package com.example.projetobank.login;

import com.example.projetobank.model.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private Error error;

    @SerializedName("userAccount")
    private User user;

    public LoginResponse(Error error, User user) {
        this.error = error;
        this.user = user;
    }

    public Error getError() {
        return error;
    }

    public User getUser() {
        return user;
    }
}
