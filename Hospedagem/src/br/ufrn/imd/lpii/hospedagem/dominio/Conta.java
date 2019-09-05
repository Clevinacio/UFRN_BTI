package br.ufrn.imd.lpii.hospedagem.dominio;

import java.util.List;

public class Conta {
    private Integer codigo;
    private Double valor;
    private Boolean pago;
    private List<Consumo> consumos;
}
