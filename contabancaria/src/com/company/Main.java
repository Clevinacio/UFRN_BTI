package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {






    public static void main(String[] args) {
        int NumeroConta = 1000;
        Banco banco = new Banco();

        ContaCorrente wesley = new ContaCorrente(001, 0,"09297788475", "wesley");
        ContaBancaria ramon = new ContaPoupanca(002, 0, "09297848675", "Ramon");
        banco.inserir(wesley);
        banco.inserir(ramon);

        wesley.depositar(955);
        wesley.sacar(500); // 450
        wesley.mostrarDados();

        ramon.depositar(3500);
        ramon.sacar(4000); // -500
        ramon.mostrarDados();

        banco.mostrarDados();

        while(true)
        {
            Scanner sc = new Scanner(System.in);


            System.out.println("   BEM VINDO!");
            System.out.println(" 1 - CRIAR CONTA");
            System.out.println(" 2 - SELECIONAR CONTA");
            System.out.println(" 3 - REMOVER CONTA");
            System.out.println(" 4 - GERAR RELATÓRIO");
            System.out.println(" 5 - FINALIZAR");

            char op = sc.next().charAt(0);

            switch (op){
                case '1':
                {
                    System.out.println("Corrente(1) ou Poupança(2) ?");
                    op = sc.next().charAt(0);

                    while(true){
                        if(op == '1')
                        {
                            sc.nextLine();
                            System.out.println("Digite o CPF e duas vezes enter: ");
                            String cpf = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Digite o seu nome: ");
                            String name = sc.nextLine();
                            ContaCorrente aux1 = new ContaCorrente(NumeroConta, 0,cpf, name);
                            banco.inserir(aux1);
                            System.out.println("Você agora é cliente do nosso Banco. O número da sua conta é: " + NumeroConta);
                            NumeroConta++;
                            break;
                        } else
                        if(op == '2'){
                            sc.nextLine();
                            System.out.println("Digite o CPF e duas vezes enter: ");
                            String cpf = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Digite o seu nome: ");
                            String name = sc.nextLine();
                            ContaPoupanca aux1 = new ContaPoupanca(NumeroConta, 0,cpf, name);
                            banco.inserir(aux1);
                            System.out.println("Você agora é cliente do nosso Banco. O número da sua conta é: " + NumeroConta);
                            NumeroConta++;
                            break;
                        }else
                            System.out.println("Opção inválida.Tente novamente (1 ou 2)");
                        op = sc.next().charAt(0);
                    }
                }
                case '2': {
                    System.out.println("Informe o número da conta. ");
                    int aux1 = sc.nextInt();

                    while (true) {
                        if (banco.procurarConta(aux1) != null) {
                            ContaBancaria aux2 = banco.procurarConta(aux1);

                            char opt;
                            System.out.println("a - Depoisitar; b - Sacar; c - Transferir");
                            opt = sc.next().charAt(0);
                            switch (opt) {
                                case 'a':
                                    {
                                        System.out.println("Qual o valor a ser depositado? ");
                                        double valor = sc.nextInt();
                                        aux2.depositar(valor);
                                        break;
                                    }
                            }
                        } else
                            System.out.println("Conta não encontrada. Tente novamente");
                            aux1 = sc.nextInt();
                    }
                }
            }


        }
    }
}
