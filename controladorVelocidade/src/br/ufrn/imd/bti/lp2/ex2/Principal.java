package br.ufrn.imd.bti.lp2.ex2;

import br.ufrn.imd.bti.lp2.ex2.exceptions.FahException;

public class Principal {
    public static void main(String[] args){
        Conversor c = new Conversor();

        try {
            c.converter(-500);
        } catch (FahException e) {
            e.printStackTrace();
        }
    }
}
