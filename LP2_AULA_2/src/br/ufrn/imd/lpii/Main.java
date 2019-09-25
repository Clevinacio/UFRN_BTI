package br.ufrn.imd.lpii;

import br.ufrn.imd.lpii.comparators.IdadeComparator;
import br.ufrn.imd.lpii.comparators.IdadeSalarioComparator;
import br.ufrn.imd.lpii.comparators.SalarioComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Empregado e1 = new Empregado("Carlos", 5000, 52);
        Empregado e3 = new Empregado("Bruno", 5000, 20);
        Empregado e2 = new Empregado("Bruno", 8000, 32);
        Empregado e4 = new Empregado("Maria", 6500, 32);
        Empregado e5 = new Empregado("Cláudia", 7000, 38);

        List<Empregado> empregados = new ArrayList<Empregado>();
        empregados.add(e1);
        empregados.add(e2);
        empregados.add(e3);
        empregados.add(e4);
        empregados.add(e5);

        System.out.println("\nOrdenando por nome");
        Collections.sort(empregados);
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }

        System.out.println("\nOrdenando por salário");
        SalarioComparator sc = new SalarioComparator();
        Collections.sort(empregados,sc);
        System.out.println("Crescente");
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }
        System.out.println("Decrescente");
        Collections.reverse(empregados);
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }


        System.out.println("\nOrdenando por idade");
        IdadeComparator ic = new IdadeComparator();
        Collections.sort(empregados,ic);
        System.out.println("Crescente");
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }
        System.out.println("Decrescente");
        Collections.reverse(empregados);
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }

        System.out.println("\nOrdenando por idade e salário");
        IdadeSalarioComparator isc = new IdadeSalarioComparator();
        Collections.sort(empregados,isc);
        for (Empregado empregado : empregados) {
            System.out.printf(empregado.toString());
        }

    }
}


