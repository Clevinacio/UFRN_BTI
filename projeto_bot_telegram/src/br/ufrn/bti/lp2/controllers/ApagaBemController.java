package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.interfaces.CommandController;
import br.ufrn.bti.lp2.objects.Bem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApagaBemController extends CommandController {
    public ApagaBemController() {
        super("/apagabem", 4);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException
    {
        List<String> texto = new ArrayList<String>();
        ListaBemController lista = new ListaBemController();
        FuncoesUteisController func = new FuncoesUteisController();
        List<Bem> bens = func.listaBens();
        Bem bem = null;
        Integer codigo;

        switch (getEtapaAtual())
        {
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
                texto.add("Digite o codigo do bem a ser removido");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 3:

                try {
                    codigo = Integer.parseInt(mensagemRecebida);
                } catch (NumberFormatException e){
                    texto.add("Nesse momento eu preciso que você informe apenas número");
                    texto.add("Vamos tentar novamente!");
                    break;
                }

                bem = buscaBemCod(bens, codigo);

                if(bem == null)
                {
                    System.out.println("bem não existente ou código inválido. Tente novamente ou digite /cancelar para sair. ");

                }else
                    bens.remove(bem);
                /*Salva informacoes no arquivo*/
                BufferedWriter arq = new BufferedWriter(new FileWriter("bem.txt"));

                for (Bem current : bens)
                {
                    arq.write(current.getCodigo() + "\n" + current.getNome() + "\n" + current.getDescricao() + "\n" + current.getCategoria().getCodigo()
                            + "\n" + current.getLocalizacao().getNome() + "\n********************");
                    arq.newLine();;
                }
                arq.close();
                texto.add("Bem apagado com sucesso");
                texto.add("Fim do processo");
                setEtapaAtual(getEtapaAtual() + 1);
            default:
                System.out.println("Operação inválida");
                break;
        }

        return texto;
    }


    @Override
    protected String confirmarOperacao() {
        return null;
    }

    @Override
    public void reset() {

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
    public Bem buscaBemCod(List<Bem> bens, int cod) {
        Bem bem = null;
        for (Bem current : bens) {
            if (cod == current.getCodigo()) {
                bem = current;
            }
        }
        return bem;
    }
}