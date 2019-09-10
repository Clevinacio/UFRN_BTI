package br.ufrn.imd.lpii.util;

public class Resultado extends MostrarResultado{
    @Override
    public void mostrar(OperacoesBasicas op) {
        System.out.println("Resultado: "+op.soma(5,2));
    }
}
