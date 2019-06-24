package com.example.projetobank.lista;

public class Statements {
    private String title;
    private String desc;
    private String date;
    private float value;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public float getValue() {
        return value;
    }

    public Statements(String title, String desc, String date, float value) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.value = value;
    }
}
