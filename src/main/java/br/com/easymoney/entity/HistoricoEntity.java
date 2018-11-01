package br.com.easymoney.entity;

import java.io.Serializable;
import java.util.Date;

public class HistoricoEntity implements Serializable {
    private int id;
    private String dataHistorico;
    private double preco;

    public HistoricoEntity() {
    }

    public HistoricoEntity(int id, String dataHistorico, double preco) {
        this.id = id;
        this.dataHistorico = dataHistorico;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHistorico() {
        return dataHistorico;
    }

    public void setDataHistorico(String dataHistorico) {
        this.dataHistorico = dataHistorico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
