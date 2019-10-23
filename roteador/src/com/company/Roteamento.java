package com.company;

public interface Roteamento {
    //Metodo roteamento: roteamento(Pacote pacote) - recebe o pct, lê o campo destino, retorna qual porta ele deve ir para chegar a destino.
    // Vê se vai para um lado ou outro, se não, checa os lados dos 2 próximos, se não, manda pro central e checa dai. Se sim em uma das outras perguntas, envia pra la.
}
