package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaBemCategoriaController extends CommandController {
    FuncoesUteisController aux = new FuncoesUteisController();

    public BuscaBemCategoriaController() {
        super("/buscarBemCategoria", 2);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        List<Bem> bens = aux.listaBens();

        switch (getEtapaAtual()) {
            case 1:
                texto.add("Diz aí a categoria do bem que você quer");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                String categoria = mensagemRecebida;

                List<Bem> found = buscabemCategoria(bens, categoria);

                if (found.isEmpty()) {
                    texto.add("Acho que a localização que você botou não existe");
                    texto.add("Tenta novamente, mas se quiser sair, digita /cancelar e " +
                            "cadastra um bem novo com /addbem e a categoria que você tá tentando");
                    break;
                }

                texto.add("Bens encontrados:\n\n");
                for (Bem current : found) {
                    texto.add("Código: " + current.getCodigo() + "\n" +
                            "Nome: " + current.getNome() + "\n" +
                            "Descrição: " + current.getDescricao() + "\n" +
                            "Categoria: " + current.getCategoria().getNome() + "\n" +
                            "Localização: " + current.getLocalizacao().getNome() + "\n\n");
                }

                setEtapaAtual(getEtapaAtual() + 1);
                break;
        }
        return texto;
    }

    public List<Bem> buscabemCategoria(List<Bem> bens, String categoria) {
        List<Bem> result = new ArrayList<Bem>();
        for (Bem current : bens) {
            if (categoria.equalsIgnoreCase(current.getCategoria().getNome())) {
                result.add(current);
            }
        }

        return result;
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
