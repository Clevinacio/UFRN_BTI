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
        super("/apagabem", 3);
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
                texto.add("Vamos ver em qual local está seu bem");
                texto.add(lista.conversar("listagem de bens").get(0));
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                codigo = Integer.parseInt(mensagemRecebida);

                for (Bem current:bens)
                {
                    if(current.getCodigo() == codigo)
                    {
                        bem = current;
                        setEtapaAtual(getEtapaAtual() + 1);
                        break;
                    }
                }
                System.out.println("Bem não existente! Tente novamente com Bem válido.");
            case 3:
                texto.add("Tem certeza que deseja apagar a categoria? (s/n)");
                if (mensagemRecebida == "S" || mensagemRecebida == "s")
                {
                    bens.remove(bem);
                    /*Salva informacoes no arquivo*/
                    BufferedWriter arq = new BufferedWriter(new FileWriter("bem.txt"));

                    for (Bem current : bens)
                    {
                        arq.write(current.getCodigo());
                        arq.write(current.getNome());
                        arq.write(current.getDescricao());
                        arq.write(current.getCategoria().getNome());
                        arq.write(current.getLocalizacao().getNome());
                        arq.write("********************");
                        arq.newLine();
                    }
                    arq.close();
                    texto.add("Fim do processo");
                }
                System.out.println("operação cancelada");
            default:
                System.out.println("Operação inválida");
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
}