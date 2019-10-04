package com.company.comparators;

import com.company.ContaBancaria;

import java.util.Comparator;
import java.util.ConcurrentModificationException;

public class CPFNomeComparator implements Comparator<ContaBancaria> {

    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        if (c1.getNomeTitular().compareTo(c2.getNomeTitular()) == 0) {
            return c1.getCpfTitular().compareTo(c2.getCpfTitular());
        }

        return c1.getNomeTitular().compareTo(c2.getNomeTitular());

    }
}
