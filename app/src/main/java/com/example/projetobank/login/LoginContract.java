package com.example.projetobank.login;

import android.content.Context;

import com.example.projetobank.model.User;

public class LoginContract {
    public interface View{

        void navigateToList(User user );
        Context getContext();
        Context getActivity();


    }
    public interface Presenter{
        void login(String username, String password);
    }
}
