package com.company.comparators;

import com.company.ContaBancaria;

import java.util.Comparator;

public class NomeStatusComparator implements Comparator<ContaBancaria> {

    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        if (c1.getNomeTitular().compareTo(c2.getNomeTitular()) == 0) {
            StatusContaComparator s1 = new StatusContaComparator();
            return s1.compare(c1, c2);
        }

        return c1.getNomeTitular().compareTo(c2.getNomeTitular());
    }
}
