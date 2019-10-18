package br.ufrn.imd.bti.lp2.ex1;

import br.ufrn.imd.bti.lp2.ex1.exceptions.PistaException;

public class Aplicacao {

    public static void main(String[] args) {
        Pista p = new Pista();

        try {
            p.iniciar();
        } catch (PistaException e) {
            e.printStackTrace();
        }
    }
}