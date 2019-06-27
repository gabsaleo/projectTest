package com.example.projetobank.login;

import com.example.projetobank.infra.Api;
import com.example.projetobank.infra.RetrofitClient;
import com.example.projetobank.model.UserContract;
import com.example.projetobank.infra.BaseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAuth implements UserContract.IUserRepository {



    @Override
    public void login(String username, String password, final BaseCallback<LoginResponse> onResult) {
        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .createService(Api.class)
                .userLogin(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    LoginResponse loginResponse = response.body();
                   onResult.onSuccessful(loginResponse);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                onResult.onUnsuccessful(t.getMessage());
            }
        });
    }
}
