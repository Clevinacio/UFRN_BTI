package com.company;

public class Pacote {
    private String dados; //(conterá os dados a serem enviados pelos pacotes)
    private Roteador destino;
    private String caminho; // Registro da tragetória feita pelo pacote até chegar no seu destino.

    public Pacote(String dados, Roteador destino) {
        this.dados = dados;
        this.destino = destino;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public Roteador getDestino() {
        return destino;
    }

    public void setDestino(Roteador destino) {
        this.destino = destino;
    }

}
