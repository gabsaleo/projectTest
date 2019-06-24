package com.example.projetobank.ui;

import com.example.projetobank.model.Login;


public interface BaseCallback<T> {
    void onSuccessful (T value);
    void onUnsuccessful (String error);
}
