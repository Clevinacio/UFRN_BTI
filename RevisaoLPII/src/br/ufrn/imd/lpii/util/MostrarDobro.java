package br.ufrn.imd.lpii.util;

public class MostrarDobro extends MostrarResultado{
    @Override
    public void mostrar(OperacoesBasicas op) {
        System.out.println("Dobro de "+op.soma(5,2)+": "+op.soma(5,2)*2);
    }
}
