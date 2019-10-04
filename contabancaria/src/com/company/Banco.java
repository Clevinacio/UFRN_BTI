package com.company;

import com.company.comparators.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public Banco() {
    }

    public boolean criarConta(String nome, String cpf){
        System.out.println("Para Conta Corrente 1, Conta Poupança 2");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 :
                ContaBancaria c1 = new ContaCorrente(contas.size()+1, cpf, nome);
                inserir(c1);
                return true;

            case 2 :
                ContaBancaria c2 = new ContaPoupanca(contas.size()+1, cpf, nome);
                inserir(c2);
                return true;

            default:
                System.out.println("Comando inválido");
                return false;
        }
    }
    public void encerrarConta(String cpf){
        for (ContaBancaria x : contas) {
            if (x.getCpfTitular().equals(cpf)) {
                if (x.isAtiva()) {
                    x.setDataEncerramento(LocalDateTime.now());
                    x.setAtiva(false);
                    System.out.println("Conta encerrada com sucesso");
                    return;
                } else if (!x.isAtiva()) {
                    System.out.println("Conta já desativada");
                    return;
                }else{
                    System.out.println("Conta inexistente");
                }

            }
        }
    }

    public void inserir(ContaBancaria conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
            System.out.println("Conta adicionada");
            return;
        }
        System.out.println("Conta já cadastrada");
    }

    public void remover(ContaBancaria conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            System.out.println("Conta removida");
            return;
        }

    }

    public ContaBancaria procurarConta(int numero) {
        for (ContaBancaria x : contas) {
            if (x.getNumero() == numero) {
                return x;
            }
        }
        return null;
    }


    public ContaBancaria procurarContaCPF(String cpf) {
        for (ContaBancaria x : contas) {
            if (x.getCpfTitular() == cpf) {
                return x;
            }
        }
        return null;
    }


    public ArrayList<ContaBancaria> procurarContaPorTitular(String nome) {
        ArrayList<ContaBancaria> contasTitular = new ArrayList<>();
        for (ContaBancaria x : contas) {
            if (x.getNomeTitular().contains(nome)) {
                contasTitular.add(x);
            }
        }
        return contasTitular;
    }

    public ArrayList<ContaBancaria> procurarContaPorCPF(String cpf) {
        ArrayList<ContaBancaria> contasCPF = new ArrayList<>();
        for (ContaBancaria x : contas) {
            if (x.getCpfTitular().equals(cpf)) {
                contasCPF.add(x);
            }
        }
        if (contasCPF.size() == 0) {
            System.out.println("Nenhuma conta encontrada para esse cpf");
            return null;
        }
        return contasCPF;
    }

    public void relatorioOrdenado(int op) {
        switch (op) {
            case 1:
                Collections.sort(contas);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            case 2:
                CPFComparator cc = new CPFComparator();
                Collections.sort(contas, cc);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            case 3:
                CPFNomeComparator cn = new CPFNomeComparator();
                Collections.sort(contas, cn);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            case 4:
                StatusContaComparator sc = new StatusContaComparator();
                Collections.sort(contas,sc);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            case 5:
                NomeStatusComparator ns = new NomeStatusComparator();
                Collections.sort(contas, ns);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            case 6:
                CPFStatusComparator cs = new CPFStatusComparator();
                Collections.sort(contas, cs);
                for (ContaBancaria c : contas) {
                    c.mostrarDados();
                    System.out.println();
                }
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void mostrarDados() {
        for (ContaBancaria x : contas) {
            x.mostrarDados();
        }
    }
}
