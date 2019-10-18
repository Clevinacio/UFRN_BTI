package br.ufrn.imd.bti.lp2.ex3;

import br.ufrn.imd.bti.lp2.ex3.exceptions.ContaExcecao;

public class TestaContaExcecao {
    public static void main(String[] args) {
        Conta c = new Conta();
        try {
            c.sacar(500);
        } catch (ContaExcecao contaExcecao) {
            contaExcecao.printStackTrace();
        }
    }
}
