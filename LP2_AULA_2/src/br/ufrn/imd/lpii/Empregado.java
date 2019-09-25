package br.ufrn.imd.lpii;

public class Empregado implements Comparable<Empregado> {
    String nome;
    double salario;
    int idade;

    public Empregado(String nome, double salario, int idade) {
        this.nome = nome;
        this.salario = salario;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: "+this.getNome()+
               " \t Salário: "+this.getSalario()+
               " \t Idade: "+this.getIdade()+'\n';
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public int compareTo(Empregado empregado) {
        return nome.compareTo(empregado.nome);
    }
}
