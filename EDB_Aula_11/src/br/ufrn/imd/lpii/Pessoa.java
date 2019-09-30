package br.ufrn.imd.lpii;

import java.util.ArrayList;
import java.util.List;

public class Pessoa{
    private String nome;
    private int idade;
    private List<CapturaEventos> catches = new ArrayList<>();

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    //Adiciona a fila responsável por realizar os eventos da pessoa
    public void addCapturador(FilaBanco f) {
        catches.add(f);
    }
    //remove a fila responsável por realizar os eventos da pessoa
    public void removeCapturador(FilaBanco f) {
        catches.remove(f);
    }


    public void setIdade(int idade) {
        int old = getIdade();
        this.idade = idade;
        for (CapturaEventos c : catches) {
            c.realizarEvento(this, old);

        }
    }

}


