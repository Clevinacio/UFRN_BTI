package br.ufrn.lp.ClassesBase;

/**
 * Classe com dados dos hóspedes do hotel
 * @author cleverton
 *
 */
public class Hospede {
	private int codigo;
	private String nome;
	private String cpf;
	private String rg;
	private String tel;
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getTel() {
		return tel;
	}

	/**
	 * Construtor de Hospede
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param rg
	 * @param tel
	 */
	public Hospede(int codigo, String nome, String cpf, String rg, String tel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.tel = tel;
	}

	
}
