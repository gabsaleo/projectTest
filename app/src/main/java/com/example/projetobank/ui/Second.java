package com.example.projetobank.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.projetobank.R;
import com.example.projetobank.infra.IStatementsServices;
import com.example.projetobank.infra.RetrofitClient;
import com.example.projetobank.statements.Adapter;
import com.example.projetobank.statements.Statement;
import com.example.projetobank.statements.StatementResponse;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Second extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Statement> statements;
    private Adapter adapter;

    TextView nameUser, nameSaldo, nameBalance, nameCount, nameBankAccount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);
        nameUser = findViewById(R.id.nameUser);
        nameSaldo = findViewById(R.id.nameSaldo);
        nameBalance = findViewById(R.id.nameBalance);
        nameCount = findViewById(R.id.nameCount);
        nameBankAccount = findViewById(R.id.nameBankAccount);



        Bundle b = getIntent().getExtras();
        if(b!= null){
            nameUser.setText(b.getString("name"));
            nameBankAccount.setText(b.getString("bankAccount" + "/" + "Agency"));

            Locale locale = new Locale("pt", "BR");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            String currency = format.format(b.getFloat("Balance"));
            nameBalance.setText(currency);
            getStatements(b.getLong("id"));


        }

    }
    public void configAdapter(List<Statement> statementList){
        adapter = new Adapter((ArrayList<Statement>) statements);
        recyclerView = findViewById(R.id.recyclerView);
       recyclerView.setHasFixedSize(true);
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
       recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void getStatements(long id){
        Call<StatementResponse> call = RetrofitClient.getInstance()
                .createService(IStatementsServices.class).getStatementList(id);
        call.enqueue(new Callback<StatementResponse>() {
            @Override
            public void onResponse(Call<StatementResponse> call, Response<StatementResponse> response) {
                StatementResponse statementResponse = response.body();
                statements = new ArrayList<Statement>(statementResponse.getStatementList());
                configAdapter(statementResponse.getStatementList());

            }

            @Override
            public void onFailure(Call<StatementResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });




    }



    }

