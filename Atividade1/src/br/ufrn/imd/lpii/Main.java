package br.ufrn.imd.lpii;
import java.util.*;
public class Main {
	public static void retornaMenu() {
		System.out.println("Escolha uma opção:");
		System.out.println("1- Ligar lâmpada");
		System.out.println("2- Desligar lâmpada");
		System.out.println("3- Ver estado");
		System.out.println("0- Sair");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lampada l1 = new Lampada();
		int op= 1;

		while (op!=0) {
			retornaMenu();
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				l1.ligarLampada();
				break;

			case 2:
				l1.desligarLampada();
				break;
			case 3:
				l1.verEstado();
			
			case 0:
				System.out.println("Tchau");
				break;
			default:
				System.out.println("Valor inválido");
				break;
			}
		}
	}

}
