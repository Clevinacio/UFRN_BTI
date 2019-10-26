package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Roteador extends DispositivoDeRede implements Roteamento {
    private String local; // Aqui é a posiçao do roteador para que seja registrado no pacote por onde ele passou.

    //As portas laterais recebem e jogam tudo para a entrada (buffer de pacotes)
    private Porta cima;
    private Porta baixo;
    private Porta direita;
    private Porta esquerda;
    private Queue<Pacote> entrada = new LinkedList<>(); //(deve conter um buffer/fila que guarde tipo Pacotes enquanto o arquivo não sai do roteador)
    private int x, y;
    /*
      Haverão 4 portas para comunicação entre eles mesmos + 1 porta rede (quando chegar no roteador destino
      é por essa porta que esses pacotes deverão passar)*/
    private Porta rede;

    public Roteador(String enderecoIP) {
        this.setEnderecoIp(enderecoIP);
    }

    public Roteador(){}

    public Porta roteamento(Pacote Pacote) {
        return null;
    }

    public void adicionarPacote(Pacote pacote) {
        entrada.add(pacote);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Porta getCima() {
        return cima;
    }

    public void setCima(Porta cima) {
        this.cima = cima;
    }

    public Porta getBaixo() {
        return baixo;
    }

    public void setBaixo(Porta baixo) {
        this.baixo = baixo;
    }

    public Porta getDireita() {
        return direita;
    }

    public void setDireita(Porta direita) {
        this.direita = direita;
    }

    public Porta getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Porta esquerda) {
        this.esquerda = esquerda;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
