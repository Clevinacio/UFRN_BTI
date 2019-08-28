package br.ufrn.lp.ClassesBase;

import java.util.Date;

public class ServicoQuarto {
	private String data;
	private Hospedagem hospedagem;
	private Camareira camareira;
	private boolean realizado;
	
	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public Camareira getCamareira() {
		return camareira;
	}


	public void setCamareira(Camareira camareira) {
		this.camareira = camareira;
	}
	
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	public void agendarServicoQuarto(Hospedagem h1, Camareira c1) {
		hospedagem = h1;
		camareira = c1;
		realizado = false;
	}

	public void realizarServicoQuarto(Hospedagem h1, Camareira c1) {
		realizado = true;
	}

	public String getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	public void setData(String string) {
		this.data = string;
		
	}
}
