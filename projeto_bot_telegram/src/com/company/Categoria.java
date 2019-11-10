package com.company;

public class Categoria {
    private int codigo;
    private String nome;
    private String descricao;

    public Categoria() {
        this.nome = "";
        this.codigo = 0;
        this.descricao = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
