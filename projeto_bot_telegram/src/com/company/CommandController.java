package com.company;

public abstract class CommandController {
    private final String comando;
    private int etapaAtual;
    private int totalEtapas;

    public CommandController(String comando, int totalEtapas) {
        this.comando = comando;
        this.totalEtapas = totalEtapas;
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

    protected abstract void reset();

    public int getTotalEtapas() {
        return totalEtapas;
    }
}
