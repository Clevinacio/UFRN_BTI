package br.ufrn.imd.lpii.comparators;

import br.ufrn.imd.lpii.Empregado;

import java.util.Comparator;

public class IdadeComparator implements Comparator<Empregado> {

    @Override
    public int compare(Empregado e1, Empregado e2) {
        if (e1.getIdade() < e2.getIdade()) {
            return -1;
        }
        if (e1.getIdade() > e2.getIdade()) {
            return 1;
        }
        return 0;
    }
}
