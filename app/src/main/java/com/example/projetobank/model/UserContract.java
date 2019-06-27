package com.example.projetobank.model;

import com.example.projetobank.login.LoginResponse;
import com.example.projetobank.infra.BaseCallback;

public class UserContract {
    public interface IUserRepository{
        void login(String username, String password, BaseCallback<LoginResponse> onResult);
    }
}
