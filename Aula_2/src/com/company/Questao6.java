package com.company;
/*
 * Caso base: 0 se n==0, 1 se n==1 e 2 se n==2
 * Passo recursivo: f(3 ∗ f (n − 1) + 4 ∗ f (n − 2))
 * Complexidade: O(n)
 */

public class Questao6 {
    public int senquenciaRecursiva(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return 3 * senquenciaRecursiva(n - 1) + 4 * senquenciaRecursiva(n - 2);
    }
}
