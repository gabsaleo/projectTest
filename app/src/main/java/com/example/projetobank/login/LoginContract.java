package com.example.projetobank.login;

import android.content.Context;

import com.example.projetobank.model.User;

public class LoginContract {
    public interface View{

        void navigateToList(User user );

        Context getContext();

        Context getActivity();

        void enableButton(boolean b);

        void errorPassword(String s);

        void errorUsername(String s);


    }
    public interface Presenter{

        void login(String username, String password);

        boolean validUsername(String user);

        boolean validPassword(String password);

    }
}
