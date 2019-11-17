package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaBemCodigoController extends CommandController {
    FuncoesUteisController aux = new FuncoesUteisController();

    public BuscaBemCodigoController() {
        super("/buscarCodBem", 2);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        List<Bem> bens = aux.listaBens();

        switch (getEtapaAtual()) {
            case 1:
                texto.add("Diz aí o código do bem que você quer");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                int cod = 0;
                try {
                    cod = Integer.parseInt(mensagemRecebida);
                } catch (NumberFormatException e){
                    texto.add("Nesse momento eu preciso que você informe apenas número");
                    texto.add("Vamos tentar novamente!");
                    break;
                }

                Bem found = buscaBemCod(bens,cod);

                if (found == null) {
                    texto.add("Acho que o código que você botou não existe");
                    texto.add("Tenta novamente, mas se quiser sair, digita /cancelar e " +
                                "cadastra um bem novo com /addbem e o código que você tá tentando");
                    break;
                }

                texto.add("Bem encontrado:\n\n" +
                        "Código: "+found.getCodigo()+"\n" +
                        "Nome: "+found.getNome()+"\n" +
                        "Descrição: "+found.getDescricao()+"\n" +
                        "Categoria: "+found.getCategoria().getNome()+"\n" +
                        "Localização: "+found.getLocalizacao().getNome());

                setEtapaAtual(getEtapaAtual() + 1);
                break;
        }
        return texto;
    }

    public Bem buscaBemCod(List<Bem> bens, int cod) {
        Bem bem = null;
        for (Bem current : bens) {
            if (cod == current.getCodigo()) {
                bem = current;
                break;
            }
        }

        return bem;
    }

    @Override
    protected String confirmarOperacao() {
        return null;
    }

    @Override
    protected void reset() {
        setEtapaAtual(1);
    }
}
