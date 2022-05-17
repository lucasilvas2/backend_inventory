package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPredio;

    @Column(columnDefinition = "TEXT")
    private String logradouro;

    @Column(columnDefinition = "INTEGER")
    private Integer numero;

    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @Column(columnDefinition = "TEXT")
    private String bairro;

    public long getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(long idPredio) {
        this.idPredio = idPredio;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
