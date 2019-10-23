package com.company;

public class Roteador extends DispositivoDeRede implements Roteamento{
    //Portas - Atributo
    /*(deve conter um buffer/fila que guarde tipo Pacotes enquanto o arquivo não sai do roteador)
      Haverão 4 portas para comunicação entre eles mesmos + 1 porta rede (quando chegar no roteador destino
      é por essa porta que esses pacotes deverão passar)*/

    //Buffers - Atributo

    public Pacote roteamento(Pacote Pacote){
        return Pacote;
    }

    /* QUANDO O PACOTE CHEGA NO ROTEADOR DESTINO1:
     Quando os pacotes chegarem no seu respectivo destino, devem sair pela porta correspondente e ter o conteúdo
     de cada pacote que chega gravado em um arquivo com o nome ip.txt, onde ip é o número IP do roteador corresponde.
     */
}
