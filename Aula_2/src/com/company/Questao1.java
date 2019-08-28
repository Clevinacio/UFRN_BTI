package com.company;

/* Questão 1:
* Caso base: 1 se n==0
* Passo recursivo: n*f(n-1)
* Complexidade: O(n)
*/

public class Questao1 {
    public int fatorialRecursivo(int num){
        if (num==0) {
            return 1;
        }

        return num*fatorialRecursivo(num-1);
    }
}
