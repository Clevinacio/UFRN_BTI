package br.ufrn.imd.bti.lp2.ex2;

import br.ufrn.imd.bti.lp2.ex2.exceptions.FahException;

public class Conversor {

    public void converter(double temp) throws FahException {
        if (temp>-459.67) {
            double c = (5 * (temp - 32))/9;
        }else {
            throw new FahException("Zero absoluto");
        }


    }
}
