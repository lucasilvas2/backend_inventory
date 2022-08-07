package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    @Column(columnDefinition = "TEXT")
    private String logradouro;

    @Column(columnDefinition = "INTEGER")
    private Integer numero;

    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @Column(columnDefinition = "TEXT")
    private String bairro;

    //geolocalização


    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
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
