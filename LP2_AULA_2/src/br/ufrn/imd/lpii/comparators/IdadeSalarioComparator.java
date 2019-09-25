package br.ufrn.imd.lpii.comparators;

import br.ufrn.imd.lpii.Empregado;

import java.util.Comparator;

public class IdadeSalarioComparator implements Comparator<Empregado> {
    IdadeComparator ic = new IdadeComparator();
    SalarioComparator sc = new SalarioComparator();

    @Override
    public int compare(Empregado e1, Empregado e2) {
        if (ic.compare(e1, e2) > 0) {
            return 1;
        }

        if (ic.compare(e1, e2) < 0) {
            return -1;
        }

        return sc.compare(e1, e2);
    }
}
