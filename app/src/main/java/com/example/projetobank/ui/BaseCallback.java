package com.example.projetobank.ui;


public interface BaseCallback<T> {
    void onSuccessful (T value);
    void onUnsuccessful (String error);
}
