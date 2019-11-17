package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FuncoesUteisController {
    public List<Localizacao> listaLocais() throws IOException {
        int counterBreak = 0;                                                                   //Guarda número da linha atual

        List<Localizacao> locais = new LinkedList<Localizacao>();                               //Guarda locais que estão no arquivo

        Localizacao current = new Localizacao();                                                //Categoria atual

        BufferedReader br = new BufferedReader(new FileReader("localizacao.txt"));     //Indica arquivo para leitura

        while (br.ready()) {                                                                    //Percorre linhas do arquivo
            counterBreak++;

            if (counterBreak % 3 == 0) {                                                         //Resto zero indica fim de uma localizacao
                locais.add(current);                                                            //Localizacao atual é adiciona a lista
                current = new Localizacao();                                                    //Nova localizacao é criada
                br.readLine();                                                                  //Se remover dá erro
            } else if (counterBreak % 3 == 1) {                                                  //Resto 1 - Nome
                current.setNome(br.readLine());
            } else if (counterBreak % 3 == 2) {                                                  //Resto 2 - Descricao
                current.setDescricao(br.readLine());
            }
        }

        System.out.println(locais.size());

        return locais;
    }

    public List<Categoria> listaCategorias() throws IOException, FileNotFoundException {

        int counterBreak = 0;                                                                   //Guarda número da linha atual

        List<Categoria> categorias = new LinkedList<Categoria>();                               //Guarda categorias que estão no arquivo

        Categoria current = new Categoria();                                                    //Categoria atual

        BufferedReader br = new BufferedReader(new FileReader("categoria.txt"));        //Indica arquivo para leitura

        while (br.ready()) {                                                                    //Percorre linhas do arquivo
            counterBreak++;

            if (counterBreak % 4 == 0) {                                                         //Resto zero indica fim de uma categoria
                categorias.add(current);                                                        //Categoria atual é adiciona a lista
                current = new Categoria();                                                      //Nova categoria é criada
                br.readLine();                                                                  //Se remover dá erro
            } else if (counterBreak % 4 == 1) {                                                  //Resto 1 - Código
                current.setCodigo(Integer.parseInt(br.readLine()));
            } else if (counterBreak % 4 == 2) {                                                  //Resto 2 - Nome
                current.setNome(br.readLine());
            } else if (counterBreak % 4 == 3) {                                                   //Resto 3 - Descricao
                current.setDescricao(br.readLine());
            }
        }

        return categorias;
    }

    public List<Bem> listaBens() throws IOException {
        int counterBreak = 0;                                                                   //Guarda número da linha atual

        List<Bem> bens = new LinkedList<Bem>();                               //Guarda locais que estão no arquivo
        List<Categoria> categorias = listaCategorias();
        List<Localizacao> locais = listaLocais();
        Bem current = new Bem();                                                //Categoria atual

        BufferedReader br = new BufferedReader(new FileReader("bem.txt"));     //Indica arquivo para leitura

        while (br.ready()) {                                                                    //Percorre linhas do arquivo
            counterBreak++;

            if (counterBreak % 6 == 0) {                                                         //Resto zero indica fim de uma localizacao
                bens.add(current);                                                            //Localizacao atual é adiciona a lista
                current = new Bem();                                                    //Nova localizacao é criada
                br.readLine();                                                                  //Se remover dá erro
            } else if (counterBreak % 6 == 1) {                                                  //Resto 1 - Nome
                current.setCodigo(Integer.parseInt(br.readLine()));
            } else if (counterBreak % 6 == 2) {                                                  //Resto 2 - Descricao
                current.setNome(br.readLine());
            } else if (counterBreak % 6 == 3) {
                current.setDescricao(br.readLine());
            } else if (counterBreak % 6 == 4) {
                current.setCategoria(buscaCategoria(categorias, Integer.parseInt(br.readLine())));
            } else if (counterBreak % 6 == 5) {
                current.setLocalizacao(buscaLocalizacao(locais, br.readLine()));
            }
        }
        System.out.println(bens.size());
        return bens;
    }

    public Localizacao buscaLocalizacao(List<Localizacao> locais, String nome) {
        Localizacao local = null;
        for (Localizacao current : locais) {                                                  //Percorre a lista de categoria
            if (nome.equalsIgnoreCase(current.getNome())) {                                                 //Ao encontrar, a busca é finalizada, retornando a categoria solicitada
                local = current;
                break;
            }
        }

        return local;
    }

    Categoria buscaCategoria(List<Categoria> categorias, int codigo) {
        Categoria categoria = null;
        for (Categoria current : categorias) {                                                  //Percorre a lista de categoria
            if (codigo == current.getCodigo()) {                                                 //Ao encontrar, a busca é finalizada, retornando a categoria solicitada
                categoria = current;
                break;
            }
        }

        return categoria;
    }

}