package com.company;

public abstract class CommandController {
    private final String comando;
    private int etapaAtual;

    public CommandController(String comando) {
        this.comando = comando;
        etapaAtual = 1;
    }

    public abstract String conversar(String mensagemRecebida);

    public String getComando() {
        return comando;
    }

    public int getEtapaAtual() {
        return etapaAtual;
    }

    protected void setEtapaAtual(int etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    protected abstract String confirmarOperacao();
}
