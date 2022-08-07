package com.ufrn.imd.inventario_patrimonial.models;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @Column(columnDefinition = "TEXT")
    private String nome;
    @Column(unique = true)
    @CNPJ
    private String cpnj;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
