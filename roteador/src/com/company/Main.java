package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Roteador roteadores[][] = new Roteador[3][3];
        FuncoesAuxiliares f1 = new FuncoesAuxiliares();
        Casa casa = new Casa();
        f1.inicializar(roteadores);
        f1.atribuirIps(roteadores);
        f1.atribuirCoordenadas(roteadores);
        f1.setarPortas(roteadores); //Dando ERRO
        f1.atribuirPacotes(roteadores);
        f1.rotear(roteadores);

    }

}
