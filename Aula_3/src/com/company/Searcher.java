package com.company;

public class Searcher {


    public int search(int[] numeros, int value) {
        return buscaBinaria(numeros, value, 0, numeros.length - 1);
    }

    private int buscaBinaria(int[] numeros, int value, int start, int end) {
        if (end < start) {
            return -1;
        }

        int meio = Math.floorDiv(start+end,2);

        if (value == numeros[meio]) {
            return meio;
        }

        if (value < numeros[meio]) {
            return buscaBinaria(numeros, value, start, meio - 1);
        } else {
            return buscaBinaria(numeros,value,meio + 1, end);
        }
    }
}
