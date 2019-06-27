package com.example.projetobank.statements;

import com.example.projetobank.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatementResponse {

    private List<Statement> statementList;

    private Error error;

    public StatementResponse(Error error, List<Statement> statementList) {
       this.error = error;
        this.statementList = statementList;
    }


    public Error getError() {
        return error;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }
}
