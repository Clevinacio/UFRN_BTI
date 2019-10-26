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

    /**
     * Essa função será acionada sempre que um pacote chegar a um roteador com o fito de registrar por quais roteadores ela já passou.
     * @param roteador
     */
    public void registrarPath(Roteador roteador){
        String tmp = roteador.getLocal();
        String tmp2 = this.caminho;
        this.caminho = tmp2 +","+ tmp;
    }
}
