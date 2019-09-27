package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> banco = new ArrayList<>();

    public Banco() {
    }

    public boolean criarConta(String nome, String cpf){
        System.out.println("Para Conta Corrente 1, Conta Poupança 2");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 :
                ContaBancaria c1 = new ContaCorrente(banco.size()+1, cpf, nome);
                inserir(c1);
                return true;

            case 2 :
                ContaBancaria c2 = new ContaPoupanca(banco.size()+1, cpf, nome);
                inserir(c2);
                return true;

            default:
                System.out.println("Comando inválido");
                return false;
        }
    }
    public boolean encerrarConta(String cpf){
        for (ContaBancaria x : banco) {
            if (x.getCpfTitular() == cpf) {
                if(x.isAtiva()){
                    x.setDataEncerramento(LocalDateTime.now());
                    x.setAtiva(false);
                    System.out.println("Conta encerrada com sucesso");
                    return true;
            }else
                    System.out.println("Conta já desativada");
                    return false;
        }else
                System.out.println("Conta não existente");
                return false;
        }
        return false;
    }

    public void inserir(ContaBancaria conta) {
        if (!banco.contains(conta)) {
            banco.add(conta);
            System.out.println("Conta adicionada");
            return;
        }
        System.out.println("Conta já cadastrada");
    }

    public void remover(ContaBancaria conta) {
        if (banco.contains(conta)) {
            banco.remove(conta);
            System.out.println("Conta removida");
            return;
        }
        System.out.println("Conta não existente");
    }

    public ContaBancaria procurarConta(int numero) {
        for (ContaBancaria x : banco) {
            if (x.getNumero() == numero) {
                return x;
            }
        }
        return null;
    }


    public ContaBancaria procurarContaCPF(String cpf) {
        for (ContaBancaria x : banco) {
            if (x.getCpfTitular() == cpf) {
                return x;
            }
        }
        return null;
    }


    public ArrayList<ContaBancaria> procurarContaPorTitular(String nome) {
        ArrayList<ContaBancaria> contasTitular = new ArrayList<>();
        for (ContaBancaria x : banco) {
            if (x.getNomeTitular().contains(nome)) {
                contasTitular.add(x);
            }
        }
        return contasTitular;
    }

    public ArrayList<ContaBancaria> procurarContaPorCPF(String cpf) {
        ArrayList<ContaBancaria> contasCPF = new ArrayList<>();
        for (ContaBancaria x : banco) {
            if (x.getCpfTitular() == cpf) {
                contasCPF.add(x);
            }
        }
        return contasCPF;
    }


    public void mostrarDados() {
        for (ContaBancaria x : banco) {
            x.mostrarDados();
        }
    }
}
