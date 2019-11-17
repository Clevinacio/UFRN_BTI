package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaBemCodigoController extends CommandController {

    public BuscaBemCodigoController(String comando, int totalEtapas) {
        super("/buscarBemCodigo", 2);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        List<Bem> bens = new ArrayList<Bem>();

        switch (getEtapaAtual()) {
            case 1:
                texto.add("Diz aí o código do bem que você quer");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:

        }
        return null;
    }

    @Override
    protected String confirmarOperacao() {
        return null;
    }
    @Override
    protected void reset() {

    }
}
