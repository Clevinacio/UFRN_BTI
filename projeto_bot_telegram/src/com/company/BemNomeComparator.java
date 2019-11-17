package com.company;

import java.util.Comparator;

public class BemNomeComparator implements Comparator<Bem> {
    @Override
    public int compare(Bem o1, Bem o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
