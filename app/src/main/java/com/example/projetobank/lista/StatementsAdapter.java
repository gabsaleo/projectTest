package com.example.projetobank.lista;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetobank.R;

import java.util.List;

public class StatementsAdapter extends RecyclerView.Adapter<StatementsAdapter.StatementsViewHolder> {

    private Context context;
    private List<Statements> statementsList;

    public StatementsAdapter(Context context, List<Statements> statementsList) {
        this.context = context;
        this.statementsList = statementsList;
    }

    @NonNull
    @Override
    public StatementsAdapter.StatementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_statements, parent, false);

        return  new StatementsViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull StatementsViewHolder holder, int position) {

        Statements statements = statementsList.get(position);

        holder.pagamento.setText(statements.getTitle());
        holder.conta.setText(statements.getDesc());
        holder.data.setText(statements.getDate());
        holder.preco.setText((int) statements.getValue());

    }

    @Override
    public int getItemCount() {
        return statementsList.size();
    }
    class StatementsViewHolder extends  RecyclerView.ViewHolder{

        TextView pagamento, conta, data, preco;

        public StatementsViewHolder(@NonNull View itemView) {
            super(itemView);
            pagamento = itemView.findViewById(R.id.payment);
            conta = itemView.findViewById(R.id.nameCont);
            data = itemView.findViewById(R.id.date);
            preco = itemView.findViewById(R.id.price);
        }
    }
}
