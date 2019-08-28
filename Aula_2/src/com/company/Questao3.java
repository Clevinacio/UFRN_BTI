package com.company;
/*
 * Caso base: array[o] se n==0
 * Passo recursivo: array[n]+f(array, n-1)
 * Complexidade: O(n)
 */

public class Questao3 {
    public int somaRecursiva(int[] array, int n){
        if (n == 0) {
            return array[0];
        }

         return array[n]+somaRecursiva(array,n-1);

    }
}
