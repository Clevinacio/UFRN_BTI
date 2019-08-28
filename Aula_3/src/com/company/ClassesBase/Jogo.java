package com.company.ClassesBase;

import java.util.Random;
/**
 *
 * Classe jogo: Jogo de dado que gera valor aleatório e retorna o mesmo
 * @author cleverton
 *
 * */

public class Jogo {
    private int aposta;
    private int resultado;

    /**
     * Executa o jogo atribuindo um valor aleatório para resultado
     * @para
     */
    public void executaJogo(){
        this.resultado = (new Random().nextInt(6) + 1);
    }

    public void setAposta(int aposta) {
        if (aposta < 1 || aposta > 6) {
            System.out.println("Valor Inválido");
            return;
        }
        this.aposta = aposta;
    }

    public int getAposta() {
        return aposta;
    }

    /**
     * Mostra Resultado da aposta
     */
    public void mostraResultado(){
        if (aposta < 1 || aposta > 6) {
            return;
        }
        System.out.println("Sua aposta: "+aposta+"\nResultado: "+resultado);

        if (this.resultado == this.aposta) {
            System.out.println("Parabéns, você acertou!");
        } else {
            System.out.println("Errou. Mas, continue tentando...");
        }
    }
}
