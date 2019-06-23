package com.example.projetobank.model;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public DefaultResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
