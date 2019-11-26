package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Bem;
import br.ufrn.bti.lp2.interfaces.CommandController;
import br.ufrn.bti.lp2.comparators.BemCategoriaComparator;
import br.ufrn.bti.lp2.comparators.BemLocalizacaoComparator;
import br.ufrn.bti.lp2.comparators.BemNomeComparator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GerarRelatorioArquivoController extends CommandController {
    FuncoesUteisController aux = new FuncoesUteisController();
    public GerarRelatorioArquivoController() {
        super("/relatorioarquivo", 1);
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
                BufferedWriter saida = new BufferedWriter(new FileWriter("relatorio"+formato.format(data)+".txt", true));
                BemNomeComparator nomeComparator = new BemNomeComparator();
                BemCategoriaComparator categoriaComparator = new BemCategoriaComparator();
                BemLocalizacaoComparator localizacaoComparator = new BemLocalizacaoComparator();

                saida.write("RELATÒRIO do dia "+formato2.format(data)+"\n");
                saida.write("Ordenado por Localização\n---------------\n");
                Collections.sort(bens,localizacaoComparator);
                for (Bem bem : bens) {
                    saida.write("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                saida.write("\nOrdenado por Categoria\n---------------\n");
                Collections.sort(bens,categoriaComparator);
                for (Bem bem : bens) {
                    saida.write("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                saida.write("\nBens por Nome:\n---------------\n");
                Collections.sort(bens,nomeComparator);
                for (Bem bem : bens) {
                    saida.write("Código: " + bem.getCodigo() + "\n" +
                            "Nome: " + bem.getNome() + "\n" +
                            "Descrição: " + bem.getDescricao() + "\n" +
                            "Categoria: " + bem.getCategoria().getNome() + "\n" +
                            "Localização: " + bem.getLocalizacao().getNome() + "\n-\n");
                }

                saida.close();
                texto.add("Arquivo gerado com sucesso!");
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
