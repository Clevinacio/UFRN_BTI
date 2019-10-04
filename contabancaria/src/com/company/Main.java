package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco b1 = new Banco();
        b1.criarConta("Cleverton","123");
        b1.criarConta("Cleverton","123");
        b1.criarConta("Bruno","145");
        b1.criarConta("Maria","433");
        b1.criarConta("Andre","453");
        menu(b1);
    }

    public static void menu(Banco b) {
        int op;
        do {


        Scanner sc = new Scanner(System.in);

        System.out.println("   BEM VINDO!");
        System.out.println(" 1 - CRIAR CONTA");
        System.out.println(" 2 - SELECIONAR CONTA");
        System.out.println(" 3 - REMOVER CONTA");
        System.out.println(" 4 - GERAR RELATÓRIO");
        System.out.println(" 5 - FINALIZAR");

        op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();
                    nome = sc.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();
                    b.criarConta(nome, cpf);
                    break;
                case 2:
                    System.out.print("1 para buscar por nome do titular\n2 para buscar por CPF: ");
                    int num = sc.nextInt();
                    if (num == 1) {
                        System.out.print("Digite o nome do titular: ");
                        String nomeTitular = sc.nextLine();
                        nomeTitular = sc.nextLine();
                        ArrayList<ContaBancaria> encontradas = b.procurarContaPorTitular(nomeTitular);
                        System.out.println("Contas encontradas: ");
                        for (ContaBancaria c : encontradas) {
                            c.mostrarDados();
                        }
                        break;
                    }

                    if (num == 2) {
                        System.out.print("Digite o cpf do titular: ");
                        String cpfTitular = sc.nextLine();
                        cpfTitular = sc.nextLine();
                        ArrayList<ContaBancaria> encontradas = b.procurarContaPorCPF(cpfTitular);
                        System.out.println("Contas encontradas: ");
                        for (ContaBancaria c : encontradas) {
                            c.mostrarDados();
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.print("Digite o CPF: ");
                    cpf = sc.nextLine();
                    cpf = sc.nextLine();
                    b.encerrarConta(cpf);
                    break;

                case 4:
                    System.out.println("Selecione a ordenção do relatório:");
                    System.out.println("1- Nome");
                    System.out.println("2- CPF");
                    System.out.println("3- Nome e CPF");
                    System.out.println("4- Status");
                    System.out.println("5- Nome e status");
                    System.out.println("6- CPF e status");
                    int opRelatorio = sc.nextInt();
                    b.relatorioOrdenado(opRelatorio);
                    break;

                case 5:
                    System.out.println("Programa encerrado. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }while (op!=5);
    }

}
