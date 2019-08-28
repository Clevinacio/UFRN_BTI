package com.company;
/*
 * Caso base: a, se b==1
 * Passo recursivo: a+f(a,b-1)
 * Complexidade: O(n)
 */

public class Questao5 {
    public int multiplicacaoRecursiva(int a, int b){
        if (b==1){
            return a;
        }

        return a+multiplicacaoRecursiva(a,b-1);
    }
}
