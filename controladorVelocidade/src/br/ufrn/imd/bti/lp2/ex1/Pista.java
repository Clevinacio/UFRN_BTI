package br.ufrn.imd.bti.lp2.ex1;

import br.ufrn.imd.bti.lp2.ex1.exceptions.AcimaVelocidadeException;
import br.ufrn.imd.bti.lp2.ex1.exceptions.PistaException;

public class Pista {


    public void iniciar() throws PistaException {
        try {
            Automovel a1 = new Automovel();
            Automovel a2 = new Automovel();
            Automovel a3 = new Automovel();
            a1.acelerar(130);
            a2.acelerar(120);
            a3.acelerar(140);
        } catch (AcimaVelocidadeException e) {
            throw new PistaException("Problema na pista", e);
        }
    }
}
