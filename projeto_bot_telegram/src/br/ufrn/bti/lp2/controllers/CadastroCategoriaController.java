package br.ufrn.bti.lp2.controllers;

import br.ufrn.bti.lp2.objects.Categoria;
import br.ufrn.bti.lp2.interfaces.CommandController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroCategoriaController extends CommandController {

    Categoria categoria;                             /*Objeto que o controlador trata*/

    public CadastroCategoriaController() {
        super("/addcategoria", 6);                     /*Determina o comando do controlador e quantas etapas possui*/
        categoria = new Categoria();
    }

    /*De acordo com a etapa corrente, a mensagem fornecida é tratada e
    as informacoes do objeto do comando são adicionadas */
    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        switch (getEtapaAtual()){
            case 1:
                texto.add("Preciso do nome da nova categoria de bens");               /*Determina a mensagem que sera enviada para o usuario*/
                setEtapaAtual(getEtapaAtual() + 1);             /*Incrementa a etapa, que só sera executada quando o usuario fornecer uma resposta*/
                break;
            case 2:
                categoria.setNome(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);            /*A resposta sendo validada, o proximo passo é chamado*/
                break;
            case 3:
                texto.add("Me da mais detalhes sobre essa categoria");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 4:
                categoria.setDescricao(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);            /*Apos fornecer a ultima informacao, os datos sao listados para validacao*/
                break;
            case 5:
                texto.add(confirmarOperacao());
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 6:
                if(mensagemRecebida.toLowerCase().equals("s")){               /*Verifica se o usuario aprovou a insercao de dados=*/

                    categoria.setCodigo(definirCodigo());                       /*Atribui codigo da nova categoria*/

                    /*Salva informacoes no arquivo*/
                    BufferedWriter arq = new BufferedWriter(new FileWriter("categoria.txt", true));
                    arq.write(categoria.getCodigo() + "\n" + categoria.getNome() + "\n" + categoria.getDescricao() + "\n********************");
                    arq.newLine();
                    arq.close();

                    texto.add("A essa categoria foi atribuído o código " + categoria.getCodigo());
                    texto.add("Fim do processo");

                    setEtapaAtual(getEtapaAtual() + 1);
                }else if(mensagemRecebida.toLowerCase().equals("n")){
                    texto.add("Processo cancelado");
                    setEtapaAtual(getEtapaAtual() + 1);
                }else {
                    texto.add("Resposta invalida");
                }
                break;
            default:
                texto.add("Etapa inválida");
                break;
        }
        return texto;
    }

    @Override
    protected String confirmarOperacao() {
        String texto = "Os dados passados foram \n\nNome: " + categoria.getNome() + "\nDescricao: " + categoria.getDescricao();
        texto = texto + "\n\nDeseja salvar esta operacao? (s/n)";
        return texto;
    }

    @Override
    public void reset() {                        /*Limpa todos os dados do controlador*/
        categoria = new Categoria();
        setEtapaAtual(1);
    }

    /*Verifica quantas linhas tem o arquivo de categorias cadastradas e determina o código para uma nova*/
    private int definirCodigo() throws IOException {
        File arqCategoria = new File("categoria.txt");
        LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arqCategoria));
        linhaLeitura.skip(arqCategoria.length());
        return linhaLeitura.getLineNumber()/4;
    }
}
