package br.ufrn.imd.lpii.hospedagem.dominio;

import java.util.List;

public class Hotel {
    private String nome;
    private String CNPJ;
    private List<Reserva> hospedagens;
    private List<Recepcionista> recepcionistas;
    private List<Camareiro> camareiros;
}
