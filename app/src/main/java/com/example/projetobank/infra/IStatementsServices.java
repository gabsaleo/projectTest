package com.example.projetobank.infra;

import com.example.projetobank.login.LoginResponse;
import com.example.projetobank.statements.StatementResponse;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IStatementsServices {


    @GET("statements/{id}")
    Call<StatementResponse> getStatementList(@Path("id") long id);
}
