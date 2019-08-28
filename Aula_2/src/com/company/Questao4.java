package com.company;
/*
 * Caso base: 1, se n==1
 * Passo recursivo: n+f(n-1)
 * Complexidade: O(n)
 */

public class Questao4 {
    public int somaSequenciaRecursiva(int num){
        if (num == 1) {
            return 1;
        }

        return num+somaSequenciaRecursiva(num-1);
    }
}
