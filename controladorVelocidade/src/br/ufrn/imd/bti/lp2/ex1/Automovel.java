package br.ufrn.imd.bti.lp2.ex1;

import br.ufrn.imd.bti.lp2.ex1.exceptions.AcimaVelocidadeException;

public class Automovel {
    final int velocidadeMaxima = 120;
    private int velocidadeAtual = 0;

    public void acelerar(int velocidade) throws AcimaVelocidadeException {
        if (velocidade + velocidadeAtual <= velocidadeMaxima) {
            velocidadeAtual += velocidade;
        } else {
            throw new AcimaVelocidadeException("Excedeu a velocidade máxima!");
        }



    }
}
