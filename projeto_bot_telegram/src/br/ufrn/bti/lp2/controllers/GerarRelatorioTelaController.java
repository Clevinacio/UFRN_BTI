package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Bem;
import br.ufrn.bti.lp2.interfaces.CommandController;
import br.ufrn.bti.lp2.comparators.BemCategoriaComparator;
import br.ufrn.bti.lp2.comparators.BemLocalizacaoComparator;
import br.ufrn.bti.lp2.comparators.BemNomeComparator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GerarRelatorioTelaController extends CommandController {
    FuncoesUteisController aux = new FuncoesUteisController();
    public GerarRelatorioTelaController() {
        super("/relatoriotela", 1);
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        List<Bem> bens = aux.listaBens();

        DateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");
        DateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();

        switch (getEtapaAtual()) {
            case 1:
                BemNomeComparator nomeComparator = new BemNomeComparator();
                BemCategoriaComparator categoriaComparator = new BemCategoriaComparator();
                BemLocalizacaoComparator localizacaoComparator = new BemLocalizacaoComparator();

                texto.add("RELATÒRIO do dia "+formato2.format(data)+"\n");
                texto.add("Ordenado por Localização\n---------------\n");
                Collections.sort(bens,localizacaoComparator);
                for (Bem bem : bens) {
                    texto.add("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                texto.add("\nOrdenado por Categoria\n---------------\n");
                Collections.sort(bens,categoriaComparator);
                for (Bem bem : bens) {
                    texto.add("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                texto.add("\nBens por Nome:\n---------------\n");
                Collections.sort(bens,nomeComparator);
                for (Bem bem : bens) {
                    texto.add("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                texto.add("Fim do relatório");
                setEtapaAtual(getTotalEtapas() + 1);
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
        setEtapaAtual(1);
    }
}


