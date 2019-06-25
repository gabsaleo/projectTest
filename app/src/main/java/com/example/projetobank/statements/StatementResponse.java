package com.example.projetobank.statements;

import com.example.projetobank.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatementResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    private List<Statement> statementList;

    public StatementResponse(int code, String message, List<Statement> statementList) {
        this.code = code;
        this.message = message;
        this.statementList = statementList;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }
}
