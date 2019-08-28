package br.ufrn.lp.ClassesBase;

public class Hotel {
	private String nome;
	private String cnpj;
	private Hospedagem[] hospedagens;
	private Recepcionista[] recepcionistas;
	private Camareira[] camareiras;
	
	public Hotel(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public void adicionarRecepcionista() {
		System.out.println();
	}
	
}
