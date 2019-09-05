package br.ufrn.imd.lpii.hospedagem.app;

import br.ufrn.imd.lpii.hospedagem.dominio.Hospede;
import br.ufrn.imd.lpii.hospedagem.dominio.Reserva;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hospede h1, h2;
        Reserva r = new Reserva(1);
        h1 = new Hospede(1, "Andre","456464966", "4654644", "9544651321");
        h2 = new Hospede(2, "Andre","456464966", "4654644", "9544651321");
        r.addHospedes(h1);
        r.addHospedes(h2);
        System.out.println(r);



    }
}
