package br.ufrn.lp.ClassesBase;

public class Funcionario {
	private String matricula;
	private String nome;
	private double saldo;
	
	public Funcionario(String matricula, String nome, double saldo) {
		this.matricula = matricula;
		this.nome = nome;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}
	
}
