package com.company;

public class ContaCorrente extends ContaBancaria {
    private double taxaOp = 5;

    public double getTaxaOp() {
        return taxaOp;
    }

    public ContaCorrente(int numero, String cpfTitular, String nomeTitular) {
        super(numero, cpfTitular, nomeTitular);
    }

    @Override
    public void mostrarDados()
    {
        System.out.println("Conta Corrente");
        System.out.println("Nome: "             + this.getNomeTitular());
        System.out.println("CPF: "             + this.getCpfTitular());
        System.out.println("Numero da Conta: " + this.getNumero());
        System.out.println("Saldo: R$"         + this.getSaldo());
        System.out.println("Taxa de operação: R$"         + this.getTaxaOp());

    }


    @Override
    public boolean sacar(double valor) {
        if(getSaldo()-getTaxaOp() < valor){
            System.out.println("Saldo insuficiente");
            return false;
        }
        setSaldo(getSaldo()-getTaxaOp()-valor);
        System.out.println("Saque feito com sucesso, novo saldo de " + getSaldo());
        return true;
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo()+valor);
        System.out.println("Deposito feito com sucesso. Novo saldo de: " + getSaldo());
    }
}
