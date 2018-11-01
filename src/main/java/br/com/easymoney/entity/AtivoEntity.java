package br.com.easymoney.entity;

import java.io.Serializable;

public class AtivoEntity implements Serializable {
    private int id;
    private String ativo;
    private String codAtivo;
    private double preco;

    public AtivoEntity() {
    }

    public AtivoEntity(int id, String ativo, String codAtivo, double preco) {
        this.id = id;
        this.ativo = ativo;
        this.codAtivo = codAtivo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCodAtivo() {
        return codAtivo;
    }

    public void setCodAtivo(String codAtivo) {
        this.codAtivo = codAtivo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
