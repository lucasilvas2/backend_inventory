package com.ufrn.imd.inventario_patrimonial.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBen;

    @Column(columnDefinition = "TEXT")
    private String qrcode;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

    @Enumerated(EnumType.ORDINAL)
    private TipoBem tipoBem;

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
