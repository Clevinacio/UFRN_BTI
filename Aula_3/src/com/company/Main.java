package com.company;

import com.company.ClassesBase.Jogo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogo j = new Jogo();
        System.out.print("Digite um valor: ");
        j.setAposta(sc.nextInt());
        if (j.getAposta() == 0) {
            return;
        }
        j.executaJogo();
        j.mostraResultado();
    }
}
