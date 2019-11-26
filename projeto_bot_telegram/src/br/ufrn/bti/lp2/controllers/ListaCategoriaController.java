package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.interfaces.CommandController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaCategoriaController extends CommandController {
    public ListaCategoriaController() {
        super("/listacategoria", 1);                     /*Determina o comando do controlador e quantas etapas possui*/

    }

    /*De acordo com a etapa corrente, a mensagem fornecida é tratada e
    as informacoes do objeto do comando são adicionadas */
    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        switch (getEtapaAtual()){
            case 1:
                texto.add(read("categoria.txt"));
                setEtapaAtual(getEtapaAtual() + 1);
                System.out.println(getEtapaAtual());
                break;
            default:
                texto.add("Etapa inválida");
                break;
        }
        return texto;
    }

    @Override
    protected String confirmarOperacao() {
        return "";
    }

    @Override
    public void reset() {
        /*Limpa todos os dados do controlador*/
        setEtapaAtual(1);
    }
    public String read(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
