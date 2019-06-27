package com.example.projetobank.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetobank.SharedPrefManager;
import com.example.projetobank.R;
import com.example.projetobank.model.User;
import com.example.projetobank.statements.StatementActivity;

import java.util.regex.Matcher;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    Matcher matcher;
    private Button botao;
    Context context;
    private EditText login, password;
    private SharedPrefManager sharedPrefManager;

    public LoginContract.Presenter presenter;
    private LoginResponse loginResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefManager = new SharedPrefManager(this);

        login = findViewById(R.id.test_user);
        password = findViewById(R.id.password);
        botao = findViewById(R.id.buttonSignUp);
        verifyLogin();

        presenter = new LoginPresenter(this);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validUsername(login.getText().toString());
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validPassword(password.getText().toString());
                }
            }
        });


        //userSign();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presenter.validPassword(password.getText().toString())) {
                    presenter.login(login.getText().toString(), password.getText().toString());
                }

            }
        });
        saveLogin(login.getText().toString());

    }


    //  "(?=.*[a-z])" +         //pelo menos 1 letra minuscula
    // "(?=.*[A-Z])" +   //pelo menos 1 letra maiuscula


    @Override
    public void navigateToList(User user) {

        Intent intent = new Intent(LoginActivity.this, StatementActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        //saveLogin(user.getName());

    }

    public Context getContext() {
        return this;
    }

    public Context getActivity() {
        return this;
    }

    @Override
    public void enableButton(boolean b) {
        botao.setEnabled(b);
    }

    @Override
    public void errorPassword(String s) {
        password.setError(s);
    }

    @Override
    public void errorUsername(String s) {
        login.setError(s);
    }

    public void saveLogin(String user) {
        if (user == null) {
            sharedPrefManager.saveLogin(login.getText().toString());
            Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show();
        } else if (user != null) {
            verifyLogin();
        }
    }

    public void verifyLogin() {
        if (sharedPrefManager.getItsSave() == 1) {
            login.setText(sharedPrefManager.getUser());
        }
    }
}
