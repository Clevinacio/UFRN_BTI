package br.ufrn.imd.lpii.hospedagem.dominio;

import java.util.Objects;

public class Hospede {
    private Integer codigo;
    private String nome;
    private String CPF;
    private String RG;
    private String telefone;

    public Hospede(Integer codigo, String nome, String CPF, String RG, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(codigo, hospede.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Codigo : " + this.codigo + "\n");
        sb.append("Nome : " + this.nome + "\n");
        sb.append("CPF : " + this.CPF + "\n");
        sb.append("RG : " + this.RG + "\n");
        sb.append("Telefone : " + this.telefone + "\n");
        return sb.toString();
    }
}
