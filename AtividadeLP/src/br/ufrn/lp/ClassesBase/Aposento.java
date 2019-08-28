package br.ufrn.lp.ClassesBase;

public class Aposento {
	private int codigo;
	private double valor;
	private String descricao;
	private int numero;
	
	public int getNumero() {
		return numero;
	}

	public Aposento(int codigo, double valor, String descricao, int numero) {
		this.codigo = codigo;
		this.valor = valor;
		this.descricao = descricao;
		this.numero = numero;
	}
	
	
}
