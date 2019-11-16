package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastroBemController extends CommandController {

    Bem bem;

    public CadastroBemController() {
        super("/addbem", 8);
        bem = new Bem();
    }

    @Override
    public List<String> conversar(String mensagemRecebida) throws IOException {
        List<String> texto = new ArrayList<String>();
        switch (getEtapaAtual()){
            case 1:
                texto.add("Me diz o código do novo bem");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:

                /*Adicionar aqui verificacao se o codigo passada ja se encontra entre os cadastrados*/

                try {
                    bem.setCodigo(Integer.parseInt(mensagemRecebida));
                } catch (NumberFormatException e){
                    texto.add("Nesse momento eu preciso que você informe apenas número");
                    texto.add("Vamos tentar novamente!");
                    break;
                }

                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 3:
                texto.add("Preciso agora do nome do bem");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 4:
                bem.setNome(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 5:
                texto.add("Me da mais detalhes sobre esse bem");
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 6:
                bem.setDescricao(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 7:
                texto.add("Abaixo são listadas as categorias já cadastradas");

                ListaCategoriaController listaCategoria = new ListaCategoriaController();

                texto.add(listaCategoria.conversar("listagem de categorias").get(0));

                texto.add("Por favor, informe o código da categoria que deseja atribuir ao bem que está sendo adicionado");

                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 8:
                try {
                    Categoria testeCategoria = new Categoria();
                    testeCategoria.setNome("teste_categoria");
                    testeCategoria.setCodigo(Integer.parseInt(mensagemRecebida));
                    bem.setCategoria(testeCategoria);
                } catch (NumberFormatException e){
                    texto.add("Nesse momento eu preciso que você informe apenas número");
                    texto.add("Vamos tentar novamente!");
                    break;
                }

                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 9:
                texto.add("Abaixo são listadas os locais já cadastradas");

                ListaLocalizacaoController listaLocalizacao = new ListaLocalizacaoController();

                texto.add(listaLocalizacao.conversar("listagem de locais").get(0));

                texto.add("Por favor, informe o nome do local que deseja atribuir ao bem que está sendo adicionado");

                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 10:
                Localizacao testeLocal = new Localizacao();
                testeLocal.setNome(mensagemRecebida);
                bem.setLocalizacao(testeLocal);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 11:
                texto.add(confirmarOperacao());
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 12:
                if(mensagemRecebida.toLowerCase().equals("s")){

                    /*Salva informacoes no arquivo*/
                    BufferedWriter arq = new BufferedWriter(new FileWriter("bem.txt", true));
                    arq.write(bem.getCodigo() + "\n" + bem.getNome() + "\n" + bem.getDescricao() + "\n" + bem.getCategoria().getCodigo()
                            + "\n" + bem.getLocalizacao().getNome() + "\n********************");
                    arq.newLine();
                    arq.close();

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
        String texto = "Os dados passados foram \n\nCódigo: " + bem.getCodigo() + "\nNome: " + bem.getNome() + "\nDescricao: "
                    + bem.getDescricao() + "\nCategoria: " + bem.getCategoria().getNome() + "\nLocalizacao: " + bem.getLocalizacao().getNome();
        texto = texto + "\n\nDeseja salvar esta operacao? (s/n)";
        return texto;
    }

    @Override
    protected void reset() {
        bem = new Bem();
        setEtapaAtual(1);
    }
}
