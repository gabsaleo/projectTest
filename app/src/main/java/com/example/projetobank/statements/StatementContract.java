package com.example.projetobank.statements;

import android.content.Context;

import com.example.projetobank.model.User;

import java.util.List;

public class StatementContract  {
    public interface View{

        Context getActivity();
        void showList(List<Statement> statementList);


    }
    public interface Presenter{
        void getStatement(long id);

    }
}
