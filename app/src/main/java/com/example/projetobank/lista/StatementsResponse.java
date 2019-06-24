package com.example.projetobank.lista;

import java.util.List;

public class StatementsResponse {
    private String error;
    private List<Statements> statements;

    public StatementsResponse(String error, List<Statements> statements) {
        this.error = error;
        this.statements = statements;
    }

    public String getError() {
        return error;
    }

    public List<Statements> getStatements() {
        return statements;
    }
}
