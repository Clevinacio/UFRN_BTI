package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Bem;
import br.ufrn.bti.lp2.interfaces.CommandController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaBemController extends CommandController {

    FuncoesUteisController aux = new FuncoesUteisController();

    public ListaBemController() {
        super("/listabem", 2);                     /*Determina o comando do controlador e quantas etapas possui*/

    }

    /*De acordo com a etapa corrente, a mensagem fornecida é tratada e
    as informacoes do objeto do comando são adicionadas */
    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<Bem> bens = aux.listaBens();
        List<String> texto = new ArrayList<String>();
        switch (getEtapaAtual()){
            case 1:
                texto.add("Das localizaçãos listadas a baixo digite qual você quer listar os bens");
                ListaLocalizacaoController listaLocalizacao = new ListaLocalizacaoController();
                texto.add(listaLocalizacao.conversar("listagem de locais").get(0));

                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                String local = mensagemRecebida;

                List<Bem> found = buscabemLocal(bens,local);

                if (found.isEmpty()) {
                    texto.add("Acho que a localização que você botou não existe");
                    texto.add("Tenta novamente, mas se quiser sair, digita /cancelar e " +
                            "cadastra um bem novo com /addbem e a localização que você tá tentando");
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
    public List<Bem> buscabemLocal(List<Bem> bens, String local) {
        List<Bem> result = new ArrayList<Bem>();
        for (Bem current : bens) {
            if (local.equalsIgnoreCase(current.getLocalizacao().getNome())) {
                result.add(current);
            }
        }

        return result;
    }
}
