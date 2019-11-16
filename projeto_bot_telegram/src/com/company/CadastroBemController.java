package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CadastroBemController extends CommandController {

    Bem bem;

    public CadastroBemController() {
        super("/addbem", 12);
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
                texto.add("Caso a categoria desejada não esteja entre as listadas, cancele a operacao (/cancelar) e adicione uma nova categoria (/addcategoria)");

                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 8:
                int codigo;

                try {
                    codigo = Integer.parseInt(mensagemRecebida);
                } catch (NumberFormatException e){
                    texto.add("Nesse momento eu preciso que você informe apenas número");
                    texto.add("Vamos tentar novamente!");
                    break;
                }

                List<Categoria> categorias = listaCategorias();                                  //Recebe lista de elementos do respectivo arquivo

                Categoria categoria = buscaCategoria(categorias, codigo);                       //Busca a categoria desejada pelo código informado

                if(categoria == null){
                    texto.add("Por favor, informe um dos códigos da lista acima");
                    texto.add("Caso a categoria desejada não esteja entre as listadas, cancele a operacao (/cancelar) e adicione uma nova categoria (/addcategoria)");
                }else {
                    bem.setCategoria(categoria);
                    setEtapaAtual(getEtapaAtual() + 1);
                    texto = conversar(mensagemRecebida);
                }
                break;
            case 9:
                texto.add("Abaixo são listadas os locais já cadastradas");

                ListaLocalizacaoController listaLocalizacao = new ListaLocalizacaoController();

                texto.add(listaLocalizacao.conversar("listagem de locais").get(0));

                texto.add("Por favor, informe o nome do local que deseja atribuir ao bem que está sendo adicionado");
                texto.add("Caso o local desejado não esteja entre os listados, cancele a operacao (/cancelar) e adicione uma nova localizacao (/addlocal)");

                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 10:
                List<Localizacao> locais = listaLocais();                                  //Recebe lista de elementos do respectivo arquivo

                Localizacao local = buscaLocalizacao(locais, mensagemRecebida);                       //Busca a localizacao desejada pelo nome informado

                if(local == null){
                    texto.add("Por favor, informe um dos nomes da lista acima");
                }else {
                    bem.setLocalizacao(local);
                    setEtapaAtual(getEtapaAtual() + 1);
                    texto = conversar(mensagemRecebida);
                }
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

    private Categoria buscaCategoria(List<Categoria> categorias, int codigo) {
        Categoria categoria = null;
        for (Categoria current : categorias) {                                                  //Percorre a lista de categoria
            if(codigo == current.getCodigo()) {                                                 //Ao encontrar, a busca é finalizada, retornando a categoria solicitada
                categoria = current;
                break;
            }
        }

        return categoria;
    }

    private List<Categoria> listaCategorias() throws IOException,FileNotFoundException {

        int counterBreak = 0;                                                                   //Guarda número da linha atual

        List<Categoria> categorias = new LinkedList<Categoria>();                               //Guarda categorias que estão no arquivo

        Categoria current = new Categoria();                                                    //Categoria atual

        BufferedReader br = new BufferedReader(new FileReader("categoria.txt"));        //Indica arquivo para leitura

        while (br.ready()) {                                                                    //Percorre linhas do arquivo
            counterBreak++;

            if(counterBreak % 4 == 0) {                                                         //Resto zero indica fim de uma categoria
                categorias.add(current);                                                        //Categoria atual é adiciona a lista
                current = new Categoria();                                                      //Nova categoria é criada
                br.readLine();                                                                  //Se remover dá erro
            } else if(counterBreak % 4 == 1) {                                                  //Resto 1 - Código
                current.setCodigo(Integer.parseInt(br.readLine()));
            } else if(counterBreak % 4 == 2) {                                                  //Resto 2 - Nome
                current.setNome(br.readLine());
            }else if(counterBreak % 4 == 3) {                                                   //Resto 3 - Descricao
                current.setDescricao(br.readLine());
            }
        }

        return categorias;
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
