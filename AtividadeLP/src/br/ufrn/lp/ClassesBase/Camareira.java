package br.ufrn.lp.ClassesBase;

public class Camareira extends Funcionario{

	public Camareira(String matricula, String nome, double saldo) {
		super(matricula, nome, saldo);
	}

	public String getNome() {
		return super.getNome();
	}
	
}
