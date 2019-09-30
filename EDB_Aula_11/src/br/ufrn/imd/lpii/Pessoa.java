package br.ufrn.imd.lpii;

import java.util.ArrayList;
import java.util.List;

public class Pessoa{
    private String nome;
    private int idade;
    private final List<CatchEvent> catches = new ArrayList<>();

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

    public void addCatchEvent(FilaBanco f) {
        catches.add(f);
    }

    public void removeCatchEvent(FilaBanco f) {
        catches.remove(f);
    }

    public void setIdade(int idade) {
        int old = this.getIdade();
        this.idade = idade;
        for (CatchEvent c : catches) {
            c.capture(this, old);

        }
    }

}


