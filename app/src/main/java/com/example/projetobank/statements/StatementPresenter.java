package com.example.projetobank.statements;

import android.util.Log;

import com.example.projetobank.infra.Api;
import com.example.projetobank.infra.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatementPresenter implements StatementContract.Presenter {
    private StatementContract.View view;

    public StatementPresenter(StatementContract.View view) {
        this.view = view;
    }

    @Override
    public void getStatement(long id) {
        Call<StatementResponse> call = RetrofitClient.getInstance()
                .createService(Api.class).getStatementList(id);


        call.enqueue(new Callback<StatementResponse>() {
            @Override
            public void onResponse(Call<StatementResponse> call, Response<StatementResponse> response) {
                StatementResponse statementResponse = response.body();
                List<Statement> statements = new ArrayList<Statement>(statementResponse.getStatementList());
                view.showList(statementResponse.getStatementList());

            }

            @Override
            public void onFailure(Call<StatementResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }



}
