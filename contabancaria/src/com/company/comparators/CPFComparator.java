package com.company.comparators;

import com.company.ContaBancaria;

import java.util.Comparator;

public class CPFComparator implements Comparator<ContaBancaria> {

    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        return c1.getCpfTitular().compareTo(c2.getCpfTitular());
    }
}
