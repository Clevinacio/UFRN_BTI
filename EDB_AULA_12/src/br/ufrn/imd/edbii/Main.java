package br.ufrn.imd.edbii;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] numeros = new int[20];
        Random rd = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.abs(rd.nextInt()) %100;
        }

        Sorter st = new Sorter();
        st.heapSort(numeros);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}
