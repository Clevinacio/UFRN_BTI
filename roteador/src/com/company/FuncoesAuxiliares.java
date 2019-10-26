package com.company;

import java.io.*;
import java.util.Arrays;

public class FuncoesAuxiliares {

    public void atribuirPacotes (Roteador[][] roteadores) throws IOException {

        /*Abre aquivo que identifica os capotes que devem ser enviados*/
        InputStream in = getClass().getResourceAsStream("/comunicação.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String linhaArquivo; //usada para guardar linha atual

        /*Faz leitura do arquivo linha a linha*/
        while ((linhaArquivo = reader.readLine()) != null) {

            String[] arrayLinha = linhaArquivo.split(" "); //Divide cada informacao em um array

            Pacote pacote = new Pacote(arrayLinha[3], new Roteador(arrayLinha[1])); //Cria pacote com o dado e o endereco de destino

            Roteador roteadorOrigem = buscarRoteador(roteadores, arrayLinha[0]); //Busca o roteador de origem

            if (roteadorOrigem == null) {
                System.out.println("Roteador solicitado nao pertence a rede!");
                return;
            }

            /*Adiciona pacote a fila do roteador de origem*/
            for (int i = 0; i < Integer.parseInt(arrayLinha[2]); i++) {
                roteadorOrigem.adicionarPacote(pacote);
            }

        }
    }

    /*Retoorna roteador de acordo com o endereco fornecido*/
    private Roteador buscarRoteador(Roteador[][] roteadores, String enderecoIP) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(roteadores[i][j].getEnderecoIp().equals(enderecoIP)) {
                    return roteadores[i][j];
                }
            }
        }
        return null;
    }

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
                roteadores[i][j].setX(i);
                roteadores[i][j].setY(j);
                System.out.println(roteadores[i][j].getX() + "," + roteadores[i][j].getY());
            }
        }
    }

    public void setarPortas(Roteador[][] roteadores) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (roteadores[i][j].getX() == 1 && roteadores[i][j].getY() == 1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //1,1 -> 1,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //1,1 -> 2,1

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]);//1,2 -> 1,1
                    roteadores[i + 1][j].getEsquerda().setReferencia(roteadores[i][j]);//2,1 -> 1,1

                }
                if (roteadores[i][j].getX() == 1 && roteadores[i][j].getY() == 2) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //1,2 -> 1,3
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]); //1,2 -> 2,2

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //1,3 -> 1,2
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //2,2 -> 1,2

                }
                if (roteadores[i][j].getX() == 1 && roteadores[i][j].getY() == 3) {

                    roteadores[i][j].getBaixo().setReferencia(roteadores[1 + i][j]); //1,3 -> 2,3
                    roteadores[1 + i][j].getCima().setReferencia(roteadores[i][j]); //2,3 -> 1,3

                }
                if (roteadores[i][j].getX() == 2 && roteadores[i][j].getY() == 1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //2,1 -> 2,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //2,1 -> 3,1

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //2,2 -> 2,1
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //3,1 -> 2,1

                }
                if (roteadores[i][j].getX() == 2 && roteadores[i][j].getY() == 3) {

                    roteadores[i][j].getEsquerda().setReferencia(roteadores[i][j - 1]); //2,3 -> 2,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //2,3 -> 3,3

                    roteadores[i][j - 1].getDireita().setReferencia(roteadores[i][j]); //2,2 -> 2,3
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //3,1 -> 2,1

                }
                if (roteadores[i][j].getX() == 3 && roteadores[i][j].getY() == 1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //3,1 -> 3,2
                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //3,2 -> 3,1

                }
                if (roteadores[i][j].getX() == 3 && roteadores[i][j].getY() == 2) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //3,2 -> 3,3
                    roteadores[i][j].getCima().setReferencia(roteadores[i - 1][j]); //3,2 -> 2,2

                    roteadores[i - 1][j].getBaixo().setReferencia(roteadores[i][j]);   //2,2 -> 3,2
                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //3,3 -> 3,2

                }
            }
        }
    }
}