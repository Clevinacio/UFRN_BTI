package com.company;

import java.util.Comparator;

public class Bem {
    private int codigo;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private Localizacao localizacao;

    public Bem() {
        this.codigo = 0;
        this.nome = "";
        this.descricao = "";
        this.categoria = null;
        this.localizacao = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

}
