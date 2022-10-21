package com.example.midterm_android;

import java.util.List;

public class Cata {
    private String nameCata;
    private List<Senda> sendas;

    public Cata(String nameCata, List<Senda> sendas) {
        this.nameCata = nameCata;
        this.sendas = sendas;
    }

    public String getNameCata() {
        return nameCata;
    }

    public void setNameCata(String nameCata) {
        this.nameCata = nameCata;
    }

    public List<Senda> getSendas() {
        return sendas;
    }

    public void setSendas(List<Senda> sendas) {
        this.sendas = sendas;
    }
}
