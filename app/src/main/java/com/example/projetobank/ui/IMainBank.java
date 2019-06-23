package com.example.projetobank.ui;

import com.example.projetobank.model.Login;

import retrofit2.Call;

public interface IMainBank<T> {
    void onSucessful (T value);
    void onFailure (String error);
}
