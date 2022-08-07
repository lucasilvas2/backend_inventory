package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPredio;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(columnDefinition = "TEXT")
    private String categoria;

    public long getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(long idPredio) {
        this.idPredio = idPredio;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
