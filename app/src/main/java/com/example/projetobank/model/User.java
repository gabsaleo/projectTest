package com.example.projetobank.model;

import com.example.projetobank.login.LoginResponse;
import com.example.projetobank.ui.BaseCallback;

import java.io.Serializable;

public class User implements Serializable {

    public UserContract.IUserRepository repository;

    private String username;
    private String password;

    private long userId;
    private String name;
    private String bankAccount;
    private String agency;
    private float balance;

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getAgency() {
        return agency;
    }

    public float getBalance() {
        return balance;
    }

    public User(long userId, String name, String bankAccount, String agency, float balance) {
        this.userId = userId;
        this.name = name;
        this.bankAccount = bankAccount;
        this.agency = agency;
        this.balance = balance;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login(final BaseCallback<LoginResponse> onResult) throws Exception{

        if(repository == null) throw new Exception("Repositorio nulo");

        if(username == null || username.isEmpty())
            throw new Exception("username is null or empty");
        if(password == null || password.isEmpty())
            throw new Exception("password is null or empty");

        repository.login(username, password, new BaseCallback<LoginResponse>() {

            @Override
            public void onSuccessful(LoginResponse value) {
                onResult.onSuccessful(value);
            }

            @Override
            public void onUnsuccessful(String error) {
                onResult.onUnsuccessful(error);
            }
        });

    }
    public User toDomain() {
        return new User(userId, name, bankAccount, agency, balance);
    }

}
