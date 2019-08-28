package br.ufrn.lp.ClassesBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe com dados de Recepcionistas do hotel
 * @author cleverton
 * 
 */
public class Recepcionista extends Funcionario{
	private String[] idiomasDominados = new String[5];
	private int cont = 0;

	/**
	 * Construtor Recepcionista
	 * @param matricula
	 * @param nome
	 * @param saldo
	 * @param idioma
	 */
	public Recepcionista(String matricula, String nome, double saldo, String idioma) {
		super(matricula, nome, saldo);
		setIdiomasDominados(idioma);
		
	}
	
	/**
	 * Set para idiomas
	 * @param idioma
	 */
	void setIdiomasDominados(String idioma) {
		if(cont==5) {
			System.out.println("Quantidade de idiomas atiginda");
			return;
		}
		idiomasDominados[cont] = idioma;
		cont++;
	}
	
	/**
	 * Cadastra um novo hospede no hotel
	 * @return Hospede criado
	 */
	public Hospede CadastrarHospede() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String n = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		System.out.print("RG: ");
		String rg = sc.nextLine();
		System.out.print("Telefone: ");
		String tel = sc.nextLine();
		
		Hospede h = new Hospede(r.nextInt(50)+1, n, cpf, rg, tel);
		
		System.out.println("Hóspede criado! Segue os dados");
		System.out.println("Nome: "+h.getNome());
		System.out.println("CPF: "+h.getCpf());
		System.out.println("RG: "+h.getRg());
		System.out.println("Tel: "+h.getTel());
		return h;
	}
	
	/**
	 * Realiza reserva de hospedagem
	 * @throws ParseException 
	 */
	public Hospedagem realizarReserva(Aposento ap) {
		Hospede h = CadastrarHospede();
		System.out.println();
		System.out.println("Hóspede criado. Agendando reserva");
		Conta c = new Conta();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a data de entrada (dd/mm/aaaa): ");
		String data1 = sc.nextLine();
		
		System.out.print("Digite a data de saída (dd/mm/aaaa): ");
		String data2 = sc.nextLine();
		
		Hospedagem ho = new Hospedagem(data1, data2, h, ap, c);
		return ho;
	}
	
	/**
	 * realiza serviço de quarto agendado
	 * @param hospedagem
	 * @param camareira
	 */
	public ServicoQuarto realizarServicoQuarto(Hospedagem hospedagem, Camareira camareira) {
		ServicoQuarto servicoQuarto1 = new ServicoQuarto();
		servicoQuarto1.setData("31/08/2019");
		servicoQuarto1.realizarServicoQuarto(hospedagem, camareira);
		
		return servicoQuarto1;
	}
	
	/**
	 * Agenda um novo serviço de quarto
	 * @param hospedagem
	 * @param camareira
	 * @param data
	 */
	public ServicoQuarto agendarServicoQuarto(Hospedagem hospedagem, Camareira camareira) {
		ServicoQuarto servicoQuarto1 = new ServicoQuarto();	
		servicoQuarto1.setData("31/08/2019");
		servicoQuarto1.agendarServicoQuarto(hospedagem, camareira);
		return servicoQuarto1;
	}
}
