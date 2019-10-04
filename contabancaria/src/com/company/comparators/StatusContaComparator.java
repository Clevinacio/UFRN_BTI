package com.company.comparators;

import com.company.ContaBancaria;

import java.util.Comparator;

public class StatusContaComparator implements Comparator<ContaBancaria> {


    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        if (c1.isAtiva() == false && c2.isAtiva() == true) {
            return 1;
        }

        if (c1.isAtiva() == true && c2.isAtiva() == false) {
            return -1;
        }

        return 0;
    }
}
