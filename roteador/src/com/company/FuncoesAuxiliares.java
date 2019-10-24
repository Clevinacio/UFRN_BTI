package com.company;

import java.io.*;

public class FuncoesAuxiliares {


    public void atribuirIps(Roteador[][] roteadores) throws IOException {
        InputStream in = getClass().getResourceAsStream("/ips.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String ip;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roteadores[i][j].setEnderecoIp(reader.readLine());
                System.out.println(roteadores[i][j].getEnderecoIp());
            }
        }
    }

    public void inicializar(Roteador[][] roteadores) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roteadores[i][j] = new Roteador();
            }
        }
    }


    public void atribuirCoordenadas(Roteador[][] roteadores) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                roteadores[i][j].setColX(i);
                roteadores[i][j].setColY(j);
                System.out.println(roteadores[i][j].getColX()+","+roteadores[i][j].getColY());
            }
        }
    }
}
