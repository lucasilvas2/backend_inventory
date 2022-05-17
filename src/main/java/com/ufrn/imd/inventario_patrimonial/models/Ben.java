package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ben{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBen;

    @Column(columnDefinition = "TEXT")
    private String qrcode;

    private BigDecimal valor;

    public Long getIdBen() {
        return idBen;
    }

    public void setIdBen(Long idBen) {
        this.idBen = idBen;
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
}
