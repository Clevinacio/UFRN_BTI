package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Bem;
import br.ufrn.bti.lp2.interfaces.CommandController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaBemDescricaoController extends CommandController {
    FuncoesUteisController aux = new FuncoesUteisController();

    public BuscaBemDescricaoController() {
        super("/buscarbemdescricao", 2);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        List<Bem> bens = aux.listaBens();

        switch (getEtapaAtual()) {
            case 1:
                texto.add("Diz aí a descrição do bem que você quer");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                String descricao = mensagemRecebida;

                List<Bem> found = buscaBemDescricao(bens,descricao);

                if (found.isEmpty()) {
                    texto.add("Acho que a descrição que você botou não existe");
                    texto.add("Tenta novamente, mas se quiser sair, digita /cancelar e " +
                            "cadastra um bem novo com /addbem e a descrição que você tá tentando");
                    break;
                }

                texto.add("Bens encontrados:\n\n");
                for (Bem current : found) {
                    texto.add("Código: "+current.getCodigo()+"\n" +
                              "Nome: "+current.getNome()+"\n" +
                              "Descrição: "+current.getDescricao()+"\n" +
                              "Categoria: "+current.getCategoria().getNome()+"\n" +
                              "Localização: "+current.getLocalizacao().getNome()+"\n\n");
                }

                setEtapaAtual(getEtapaAtual() + 1);
                break;
        }
        return texto;
    }

    public List<Bem> buscaBemDescricao(List<Bem> bens, String descricao) {
        descricao = descricao.toLowerCase();
        List<Bem> result = new ArrayList<Bem>();
        for (Bem current : bens) {
            if (current.getDescricao().contains(descricao)) {
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
    public void reset() {
        setEtapaAtual(1);
    }
}
