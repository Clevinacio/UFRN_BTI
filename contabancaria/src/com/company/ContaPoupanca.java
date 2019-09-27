package com.company;

import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends ContaBancaria {
    private double limite = 500;

    public double getLimite() {
        return limite;
    }

    public ContaPoupanca(int numero, String cpfTitular, String nomeTitular) {
        super(numero, cpfTitular, nomeTitular);
    }

    @Override
    public void mostrarDados()
    {
        System.out.println("Conta Poupança");
        System.out.println("Nome: "            + this.getNomeTitular());
        System.out.println("CPF: "             + this.getCpfTitular());
        System.out.println("Numero da Conta: " + this.getNumero());
        System.out.println("Saldo: R$"         + this.getSaldo());
        System.out.println("Limite: R$"        + this.getLimite());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data de Cadastro é: " +
                getDataCadastro().format(formatter));
        if(this.isAtiva())
            System.out.println("Conta ativa");
        else {
            System.out.println("Conta Desativada");
            System.out.println("Data de Encerramento é: " +
                    getDataEncerramento().format(formatter));
        }
    }


    @Override
    public boolean sacar(double valor) {
        if(getSaldo()+getLimite() < valor ){
            System.out.println("Saldo insuficiente");
            return false;
        }
        setSaldo(getSaldo()-valor);
        System.out.println("Seu novo saldo é de: " + getSaldo());
        return true;
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo()+valor);
        System.out.println("Deposito feito com sucesso. Novo saldo de: " + getSaldo());
    }
}
