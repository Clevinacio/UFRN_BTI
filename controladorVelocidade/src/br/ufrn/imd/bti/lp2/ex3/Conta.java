package br.ufrn.imd.bti.lp2.ex3;

import br.ufrn.imd.bti.lp2.ex3.exceptions.ContaExcecao;

public class Conta {
    private int saldo = 300;
    public void sacar(double valor) throws ContaExcecao {
        if (valor < saldo) {
            saldo -= valor;
        }else {
            throw new ContaExcecao("Saldo insuficiente");
        }

    }
}
