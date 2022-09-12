package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBem;

    @Column(columnDefinition = "TEXT")
    private String qrcode;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

    private Integer tipoBem;

    public Long getIdBem() {
        return idBem;
    }

    public void setIdBem(Long idBem) {
        this.idBem = idBem;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public TipoBem getTipoBem() {
        return TipoBem.valueOf(tipoBem);
    }

    public void setTipoBem(TipoBem tipoBem) {
        this.tipoBem = tipoBem.getCode();
    }
}
