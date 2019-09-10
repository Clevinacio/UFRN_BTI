package br.ufrn.imd.lpii;

import br.ufrn.imd.lpii.util.MostrarDobro;
import br.ufrn.imd.lpii.util.OperacoesBasicas;
import br.ufrn.imd.lpii.util.Resultado;

public class Main {

    public static void main(String[] args) {
        OperacoesBasicas op = new OperacoesBasicas();
        System.out.println(op.soma(5, 5));
        System.out.println(op.divisao(4,3));
        System.out.println("------------------------");
        String a[] = new String[5];

        a[0] = "João";
        a[1] = "Maria";
        a[2] = "José";
        a[3] = "Marcos";
        a[4] = "Cláudia";

        for (String x : a) {
            System.out.println(x);
        }

        System.out.println("------------------------");

        String b[][] = new String[4][3];

        System.out.println("------------------------");
        OperacoesBasicas op2 = new OperacoesBasicas();
        Resultado r = new Resultado();
        r.mostrar(op2);

        MostrarDobro m = new MostrarDobro();
        m.mostrar(op2);

    }

}
