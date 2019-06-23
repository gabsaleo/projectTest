package com.example.projetobank.infra;

import com.example.projetobank.model.DefaultResponse;
import com.example.projetobank.model.Login;
import com.example.projetobank.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(
            @Field("user") String user,
            @Field("password") String password
    );

    @POST("login")
    Call<Login> getUserAccount(long id,
                               String name,
                               String bankAccount,
                               String agency,
                               float balance);
}
