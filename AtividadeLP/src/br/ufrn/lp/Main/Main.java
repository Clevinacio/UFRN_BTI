package br.ufrn.lp.Main;

import br.ufrn.lp.ClassesBase.*;

import java.text.ParseException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		Recepcionista r = new Recepcionista("121314", "Cláudia", 500, "Espanhol");
		Camareira c = new Camareira("123123", "Luzia", 600);
		Aposento ap = new Aposento(12, 800, "Quarto duas camas", 12);

			
		Consumo consumo1 = new Consumo(10, "agua", 1, 2.0);
		Conta conta1 = new Conta();
		Aposento aposento1 = new Aposento(10, 800, "Quarto uma cama", 10);
		Hospede hospede1 = new Hospede(10, "Sergio", "123456", "123456", "94466666");
		Hospedagem hospedagem1 = new Hospedagem("10/10/2019", "15/10/2019", hospede1, aposento1, conta1);
		
		int op;
		Scanner sc = new Scanner(System.in);
		menu();
		do {
			System.out.print("Opção: ");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Cadastrando hóspede: ");
				Hospedagem ho = r.realizarReserva(ap);
				System.out.println();
				
				System.out.println("Hospedagem agendada com sucesso para "+ho.getHospede().getNome());
				System.out.println("Dados da hospedagem: ");
				System.out.println("Data de entrada: "+ho.getDataEntrada());
				System.out.println("Data de sáida: "+ ho.getDataSaida());
				System.out.println("Número do aposento: "+ho.getAposento().getNumero());
				
				System.out.println();
				System.out.println();
				menu();
				break;
			case 2:
				ServicoQuarto s1 = r.realizarServicoQuarto(hospedagem1, c);
				System.out.println("Serviço realizado por"+c.getNome()+" no dia "+s1.getData()+"\n");
				menu();
				break;
			case 3:
				ServicoQuarto s2 = r.agendarServicoQuarto(hospedagem1, c);
				
				System.out.println("Serviço agendado para "+c.getNome()+" no dia "+s2.getData()+"\n");
				
				menu();
				break;
				
			case 4:
				System.out.println("\nProduto consumido: " + consumo1.getDescricao());
				hospedagem1.registrarConsumo(consumo1);
				System.out.println("Valor da conta da hospedagem: " + hospedagem1.getConta().getValor()+"\n");
				menu();
				break;
				
			case 0:
				System.out.println("Programa encerrado.");
				break;
			default:
				break;
			}
		}while(op!=0);
	}
	
	public static void menu() {
		System.out.println("Bem-vindo ao sistema de hotel");
		System.out.println("Escolha uma opção:");
		System.out.println("1- Realizar reserva");
		System.out.println("2- Realizar serviço de quarto");
		System.out.println("3- Agendar serviço de quarto");
		System.out.println("4- Registrar consumo");
		System.out.println("0- Sair");
		
	}
	

}
