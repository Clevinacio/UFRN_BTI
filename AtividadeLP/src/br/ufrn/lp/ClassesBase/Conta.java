package br.ufrn.lp.ClassesBase;

import java.util.Random;

public class Conta {
	private int codigo;
	private double valor;
	private boolean pago;
	private Consumo[] consumos;
	private int cont;
	
	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setConsumo(Consumo consumo) {
		consumos[cont] = consumo;
		this.valor += consumo.getValorUnitario() * consumo.getQuantidade();
		cont++;
	}

	public Conta() {
		Random r = new Random();
		this.codigo = r.nextInt(50)+1;
		this.pago = false;
		this.valor = 0.0;
		this.consumos = new Consumo[5];
		cont = 0;
	}
	
	
}
