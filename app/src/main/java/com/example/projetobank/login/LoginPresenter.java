package com.example.projetobank.login;

import android.widget.Toast;

import com.example.projetobank.model.User;
import com.example.projetobank.ui.BaseCallback;

public class LoginPresenter implements LoginContract.Presenter {

    public LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        final User user= new User(username, password);
        user.repository = new LoginAuth();
        try{
            user.login(new BaseCallback<LoginResponse>() {
                @Override
                public void onSuccessful(LoginResponse value) {
                    view.navigateToList(value.getUser());
                }

                @Override
                public void onUnsuccessful(String error) {
                    Toast.makeText(view.getActivity(), "erro", Toast.LENGTH_SHORT).show();
                }
            });



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
