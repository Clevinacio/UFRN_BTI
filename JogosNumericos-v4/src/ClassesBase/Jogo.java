package ClassesBase;

import ClassesBase.interfaces.interfaceJogos;

import java.util.*;

public class Jogo implements interfaceJogos {
    private int aposta;
    private int resultado;

    public void setAposta(int aposta) {
        if (aposta > 6 || aposta < 1) {
            System.out.println("Aposta inválida!");
        }
        this.aposta = aposta;
    }

    @Override
    public void executarJogo() {

    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public void executaJogo() {
        Random rnd = new Random();
        this.resultado = rnd.nextInt(6) + 1;
    }

    public void executaJogo(int aposta) {
        this.aposta = aposta;
        this.executaJogo();
    }

    public void mostraResultado() {
        System.out.println("Sua aposta: " + aposta + "\nResultado: " + resultado);

        if (this.resultado == this.aposta) {
            System.out.println("Parabéns, você acertou!");
        } else System.out.println("Errou. Mas, continue tentando...");
    }
}
