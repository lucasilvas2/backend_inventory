package com.ufrn.imd.inventario_patrimonial.models;

public enum TipoBem {
    IMOVEIS(1), MAQUINARIOS_E_EQUIPAMENTOS(2), VEICULOS(3), MOVEIS(4), ARTIGOS_DE_INFORMATICA(5), ELETRONICOS(6);

    private int code;

    private TipoBem(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoBem valueOf(int code){
        for (TipoBem value : TipoBem.values()){
            if(code == value.getCode()){
                return value;
            }
        }
        throw new IllegalArgumentException("Valor inválido");
    }
}

