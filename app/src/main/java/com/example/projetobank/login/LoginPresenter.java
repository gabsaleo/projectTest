package com.example.projetobank.login;

import android.widget.Toast;

import com.example.projetobank.model.User;
import com.example.projetobank.infra.BaseCallback;

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
                    Toast.makeText(view.getActivity(), "Sem conexão", Toast.LENGTH_SHORT).show();
                }
            });



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validUsername(String user) {
        if (user.matches("[0-9]+")) {
            if (user.length() == 11) {
                view.enableButton(true);
            }else {
                view.errorUsername("Cpf invalido");
               view.enableButton(false);
                return false;
            }

        } else {
            if (!user.matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+")) {
                view.errorUsername("Email invalido");
                view.enableButton(false);
                return false;
            }
            view.enableButton(true);

        }

        return false;
    }

    @Override
    public boolean validPassword(String password) {
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d](?=.*[!@#$*_%^&+=])(?=\\S+$)(?=\\S+$).{4,}$")) {

            return true;
        }
        view.errorPassword("Senha invalida");

        return false;
    }
}
