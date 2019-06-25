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
import com.example.projetobank.ui.Second;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

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

        //userSign();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(login.getText().toString().trim(), password.getText().toString().trim());
            }
        });
    }

    @Override
    public void navigateToList(User user) {

        Intent intent = new Intent(LoginActivity.this, Second.class);
        Bundle b = new Bundle();
        b.putLong("id", user.getUserId());
        b.putString("name", user.getName());
        b.putString("Agency", user.getAgency());
        b.putString("bankAccount", user.getBankAccount());
        b.putFloat("Balance", user.getBalance());
        intent.putExtras(b);
        startActivity(intent);
        saveLogin(user.getName());

    }

    public Context getContext() {
        return this;
    }

    public Context getActivity() {
        return this;
    }

    public void saveLogin(String user) {
        sharedPrefManager.saveLogin(login.getText().toString());
        Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show();
    }

    public void verifyLogin() {
        if (sharedPrefManager.getItsSave() == 1) {
            login.setText(sharedPrefManager.getUser());
        }
    }
}
