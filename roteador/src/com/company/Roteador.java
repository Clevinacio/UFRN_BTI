package com.company;

public class Roteador extends DispositivoDeRede implements Roteamento {
    Porta portas[] = new Porta[5];
    int colX, colY;

    public int getColX() {
        return colX;
    }

    public void setColX(int colX) {
        this.colX = colX;
    }

    public int getColY() {
        return colY;
    }

    public void setColY(int colY) {
        this.colY = colY;
    }
    /*(deve conter um buffer/fila que guarde tipo Pacotes enquanto o arquivo não sai do roteador)
      Haverão 4 portas para comunicação entre eles mesmos + 1 porta rede (quando chegar no roteador destino
      é por essa porta que esses pacotes deverão passar)*/

    //Buffers - Atributo

    public Porta roteamento(Pacote Pacote) {
        return null;
    }

}
