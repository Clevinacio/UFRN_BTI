package br.ufrn.imd.edbii;

import java.util.Random;

import static org.junit.Assert.*;

public class SorterTest {

    @org.junit.Test
    public void heapSort() {
        int numeros[] = new int[20];
        Random rd = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.abs(rd.nextInt()) %100;
        }

        Sorter st = new Sorter();
        st.heapSort(numeros);

        assertTrue(numeros[0]<numeros[1]);
    }
}