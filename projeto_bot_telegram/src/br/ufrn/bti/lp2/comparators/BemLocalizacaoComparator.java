package br.ufrn.bti.lp2.comparators;

import br.ufrn.bti.lp2.objects.Bem;

import java.util.Comparator;

public class BemLocalizacaoComparator implements Comparator<Bem> {
    @Override
    public int compare(Bem o1, Bem o2) {
        return o1.getLocalizacao().getNome().compareTo(o2.getLocalizacao().getNome());
    }
}