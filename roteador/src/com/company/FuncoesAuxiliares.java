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
                roteadorOrigem.incluirPacote(pacote);
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
            }
        }
    }

    /**
     * Nessa função, as portas estão buscando referência do seu roteador. Nos 'ifs' será sempre mostrado '-1' para ilustrar
     * o caminho feito na matriz para fazer as referências, pois matrizes, na matemática iniciam do âmbito 1x1, mas no caso
     * de nossa matriz,por causa do 'for', eles iniciam no 0x0.
     * @param roteadores
     */
    public void setarPortas(Roteador[][] roteadores) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (roteadores[i][j].getX() == 1 -1 && roteadores[i][j].getY() == 1-1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //1,1 -> 1,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //1,1 -> 2,1

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]);//1,2 -> 1,1
                    roteadores[i + 1][j].getEsquerda().setReferencia(roteadores[i][j]);//2,1 -> 1,1

                }
                if (roteadores[i][j].getX() == 1-1 && roteadores[i][j].getY() == 2-1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //1,2 -> 1,3
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]); //1,2 -> 2,2

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //1,3 -> 1,2
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //2,2 -> 1,2

                }
                if (roteadores[i][j].getX() == 1-1 && roteadores[i][j].getY() == 3-1) {

                    roteadores[i][j].getBaixo().setReferencia(roteadores[1 + i][j]); //1,3 -> 2,3
                    roteadores[1 + i][j].getCima().setReferencia(roteadores[i][j]); //2,3 -> 1,3

                }
                if (roteadores[i][j].getX() == 2-1 && roteadores[i][j].getY() == 1-1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //2,1 -> 2,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //2,1 -> 3,1

                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //2,2 -> 2,1
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //3,1 -> 2,1

                }
                if (roteadores[i][j].getX() == 2-1 && roteadores[i][j].getY() == 3-1) {

                    roteadores[i][j].getEsquerda().setReferencia(roteadores[i][j - 1]); //2,3 -> 2,2
                    roteadores[i][j].getBaixo().setReferencia(roteadores[i + 1][j]);   //2,3 -> 3,3

                    roteadores[i][j - 1].getDireita().setReferencia(roteadores[i][j]); //2,2 -> 2,3
                    roteadores[i + 1][j].getCima().setReferencia(roteadores[i][j]); //3,1 -> 2,1

                }
                if (roteadores[i][j].getX() == 3-1 && roteadores[i][j].getY() == 1-1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //3,1 -> 3,2
                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //3,2 -> 3,1

                }
                if (roteadores[i][j].getX() == 3-1 && roteadores[i][j].getY() == 2-1) {

                    roteadores[i][j].getDireita().setReferencia(roteadores[i][j + 1]); //3,2 -> 3,3
                    roteadores[i][j].getCima().setReferencia(roteadores[i - 1][j]); //3,2 -> 2,2

                    roteadores[i - 1][j].getBaixo().setReferencia(roteadores[i][j]);   //2,2 -> 3,2
                    roteadores[i][j + 1].getEsquerda().setReferencia(roteadores[i][j]); //3,3 -> 3,2

                }
            }
        }
    }

    public void rotear(Roteador[][] roteadores) {
        int cont = 9;

        while (cont != 0) {
            cont = 9;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Roteador current = roteadores[i][j];
                    if (current.getEntrada().size() > 0) {
                        while (current.getEntrada().peek() != null) {
                            Pacote pct = current.getEntrada().poll();
                            if (pct.getDestino().getEnderecoIp().equals(current.getEnderecoIp())) {
                                try {
                                    current.escrevePacote(pct);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                if (pct == null) {
                                    return;
                                }
                                Porta destino = current.roteamento(pct);
                                destino.getReferencia().adicionarPacote(pct);
                            }
                        }

                    }else {
                        cont--;
                    }
                }
            }
        }

    }
}