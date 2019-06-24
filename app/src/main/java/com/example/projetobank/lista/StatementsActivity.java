package com.example.projetobank.lista;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.projetobank.R;
import com.example.projetobank.infra.Api;
import com.example.projetobank.infra.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatementsActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private List<Statements> statementsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);

        recyclerView = findViewById(R.id.recyclerView);
        Bundle b = getIntent().getExtras();
         if(b!= null){
             CallbackStatements(b.getInt("id"));
         }




    }
    public void configAdapter(List<Statements> statements){

        StatementsAdapter adapter = new StatementsAdapter(getApplicationContext(), statements);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

    }
    public void CallbackStatements(long id ){
        Call<StatementsResponse> call = RetrofitClient
                .getInstance()
                .createService(Api.class)
                .getStatementList(id);

        call.enqueue(new Callback<StatementsResponse>() {
            @Override
            public void onResponse(Call<StatementsResponse> call, Response<StatementsResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(StatementsActivity.this, "foi", Toast.LENGTH_SHORT).show();
                    StatementsResponse statementsResponse = response.body();
                    configAdapter(statementsResponse.getStatements());
                }

            }

            @Override
            public void onFailure(Call<StatementsResponse> call, Throwable t) {
                Toast.makeText(StatementsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
