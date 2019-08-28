package com.company;
/*
* Caso base: 0 se n==1 e 1 se n==2
* Passo recursivo: f(n-1)+f(n-2)
* Complexidade: O(n)
 */

public class Questao2 {
    public int fibonacciRecursiva(int num){
        if (num==1) {
            return 0;
        }else if (num==2){
            return 1;
        }

        return fibonacciRecursiva(num-1)+fibonacciRecursiva(num-2);
    }
}
