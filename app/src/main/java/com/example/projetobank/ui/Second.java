package com.example.projetobank.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetobank.SharedPrefManager;
import com.example.projetobank.infra.Api;
import com.example.projetobank.model.Login;
import com.example.projetobank.R;
import com.example.projetobank.infra.RetrofitClient;
import com.example.projetobank.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Second extends AppCompatActivity {

    private TextView nome;
    private Login login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        nome = findViewById(R.id.nome);



        nome.setText("Salve");
       // showUser();


    }

  //  private void showUser() {

//        bank.setText(login.getBankAccount());
//        agency.setText(login.getAgency());
//        balance.setText((int) login.getBalance());


//        RetrofitClient retrofit = new RetrofitClient();
//        Api api = retrofit.getApiServices();
//        Call<Login> loginCall = api.getUserAccount(login.getUserId(),
//                login.getName(),
//                login.getBankAccount(),
//                login.getAgency(),
//                login.getBalance());
//
//        loginCall.enqueue(new Callback<Login>() {
//            @Override
//            public void onResponse(Call<Login> call, Response<Login> response) {
//                try {
//                    if (response.isSuccessful() && response.code() == 200) {
//                        Toast.makeText(Second.this, response.message(), Toast.LENGTH_SHORT).show();
//                        nome.setText(login.getUserId() + ""
//                                + login.getName() + ""
//                                + login.getBankAccount() + ""
//                                + login.getAgency() + ""
//                                + login.getBalance());
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Login> call, Throwable t) {
//                Toast.makeText(Second.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    }

