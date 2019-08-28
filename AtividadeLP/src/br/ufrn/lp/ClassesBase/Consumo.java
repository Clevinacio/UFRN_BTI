package br.ufrn.lp.ClassesBase;

public class Consumo {
	private int codigo;
	private String descricao;
	private int quantidade;
	private double valorUnitario;
	
	public Consumo(int codigo, String descricao, int quantidade, double valorUnitario) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}	
	
	
}
