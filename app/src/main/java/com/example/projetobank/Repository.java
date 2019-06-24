package com.example.projetobank;

import com.example.projetobank.infra.RetrofitClient;

public class Repository {
    public final RepositoryData data;

    protected Repository(){this.data = new RepositoryData();}

    public class RepositoryData{
        public <T> T restApi (Class<T> type){
            return (T) RetrofitClient.getInstance().createService(type);
        }
    }
}
