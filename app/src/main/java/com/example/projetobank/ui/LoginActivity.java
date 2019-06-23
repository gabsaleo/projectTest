package com.example.projetobank.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetobank.SharedPrefManager;
import com.example.projetobank.model.DefaultResponse;
import com.example.projetobank.R;
import com.example.projetobank.infra.RetrofitClient;
import com.example.projetobank.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button botao;
    Context context;
    private EditText login, password;
    private  SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefManager = new SharedPrefManager(this);

        login = findViewById(R.id.test_user);
        password = findViewById(R.id.password);
        botao = findViewById(R.id.buttonSignUp);
        verifyLogin();


        //userSign();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSign();
            }
        });

    }

    private void userSign() {
        String log = login.getText().toString().trim();
        String senha = password.getText().toString().trim();

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApiServices()
                .userLogin(log, senha);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if(response.isSuccessful()){

                    saveLogin();
                    Intent intent = new Intent(LoginActivity.this, Second.class);
                    startActivity(intent);
                    //salvar user
                    //abrir perfil

                    Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });




//        final Login login = new Login(user, password, getApplicationContext());
//        login.repository = new AuthRepository();
//        try{
//            login.login(new IMainBank<Login>() {
//                @Override
//                public void onSucessful(Login value) {
//                    Intent intent  = new Intent(MainActivity.this, Second.class);
//                    Toast.makeText(MainActivity.this, "foi", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(String error) {
//                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }catch (Exception e){
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }


    }
    public void saveLogin(){
        sharedPrefManager.saveLogin(login.getText().toString());
        Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show();
    }
    public void verifyLogin(){
        if(sharedPrefManager.getItsSave() == 1){
            login.setText(sharedPrefManager.getUser());
        }
    }


}
