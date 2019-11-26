package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Bem;
import br.ufrn.bti.lp2.interfaces.CommandController;
import br.ufrn.bti.lp2.objects.Localizacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovimentaBemController extends CommandController {

    FuncoesUteisController aux = new FuncoesUteisController();
    Bem bemMov = new Bem();
    Localizacao localMov = new Localizacao();


    public MovimentaBemController() throws IOException {
        super("/movimentabem", 4);                     /*Determina o comando do controlador e quantas etapas possui*/

    }

    /*De acordo com a etapa corrente, a mensagem fornecida é tratada e
    as informacoes do objeto do comando são adicionadas */
    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<Bem> bens = aux.listaBens();
        List<String> texto = new ArrayList<String>();
        List<Localizacao> locais = aux.listaLocais();



        switch (getEtapaAtual()){
            case 1:
                texto.add("Das localizaçãos listadas a baixo digite qual você quer listar os bens para movimentar");
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
                texto.add("Digite o codigo do bem a ser movido");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 3:

                bemMov = buscaBemCod(bens, Integer.parseInt(mensagemRecebida));
                texto.add("Para qual local o bem deve ser movido?");
                ListaLocalizacaoController listaLocalizacao2 = new ListaLocalizacaoController();
                texto.add(listaLocalizacao2.conversar("listagem de locais").get(0));
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 4:
                localMov = buscaLocalizacao(locais, mensagemRecebida);
                movimentaLocalbem(bens, bemMov, localMov);
                texto.add("Bem movimentado com sucesso!");
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

    public Bem buscaBemCod(List<Bem> bens, int cod) {
        Bem bem = null;
        for (Bem current : bens) {
            if (cod == current.getCodigo()) {
                bem = current;
            }
        }
        return bem;
    }

    public List<Bem> movimentaLocalbem(List<Bem> bens, Bem bem2, Localizacao local) throws IOException {
        List<Bem> result = new ArrayList<Bem>();
        BufferedWriter arq = new BufferedWriter(new FileWriter("bem.txt"));

        Iterator<Bem> itr = bens.iterator();
        while(itr.hasNext()) {
            Bem n = itr.next();
            if(n.getCodigo() == bem2.getCodigo()){
                itr.remove();
                bem2.setLocalizacao(local);
                arq.write(bem2.getCodigo() + "\n" + bem2.getNome() + "\n" + bem2.getDescricao() + "\n" + bem2.getCategoria().getCodigo()
                        + "\n" + bem2.getLocalizacao().getNome() + "\n********************");
                arq.newLine();
            }
        }

        for(Bem item : bens){
            arq.write(item.getCodigo() + "\n" + item.getNome() + "\n" + item.getDescricao() + "\n" + item.getCategoria().getCodigo()
                    + "\n" + item.getLocalizacao().getNome() + "\n********************");
            arq.newLine();
        }

        arq.close();
        return result;
    }

    public Localizacao buscaLocalizacao(List<Localizacao> locais, String nome) {
        Localizacao local = null;
        for (Localizacao current : locais) {                                                  //Percorre a lista de categoria
            if (nome.equalsIgnoreCase(current.getNome())) {                                                 //Ao encontrar, a busca é finalizada, retornando a categoria solicitada
                System.out.println(current.getNome());
                local = current;
                break;
            }
        }

        return local;
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
