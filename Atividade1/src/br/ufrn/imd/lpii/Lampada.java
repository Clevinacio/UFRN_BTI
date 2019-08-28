package br.ufrn.imd.lpii;

public class Lampada {
	private boolean estado = false;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void ligarLampada() {
		if (isEstado()==true) {
			System.out.println("A lâmpada já está ligada");
		}
		setEstado(true);
	}

	public void desligarLampada() {
		if (isEstado()==false) {
			System.out.println("A lâmpada já está desligada");
		}
		setEstado(false);
	}
	
	public void verEstado() {
		if (isEstado()==true) {
			System.out.println("Ligada");
		}else {
			System.out.println("Desligada");
		}
	}
	
}
