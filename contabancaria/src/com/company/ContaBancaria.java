package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public abstract class  ContaBancaria implements Imprimivel, Comparable<ContaBancaria>{
    protected int numero = 0;
    private double saldo;
    private String cpfTitular;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    private String nomeTitular;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataEncerramento;
    private boolean ativa;


    public ContaBancaria(int numero, String cpfTitular, String nomeTitular) {

        this.numero = numero;
        this.saldo = 0;
        this.cpfTitular = cpfTitular;
        this.nomeTitular = nomeTitular;
        this.dataCadastro = LocalDateTime.now();
        this.dataEncerramento = null;
        this.ativa = true;
    }

    public abstract boolean sacar(double valor);

    public abstract void depositar(double valor);

    public void transferir(double valor, ContaBancaria conta){
        if(this.sacar(valor)==true){
            conta.depositar(valor);
            System.out.println("Transferencia efetuada");
        }else{
            System.out.println("Não é possível efetuar a transferência");
        }
    }

    @Override
    public int compareTo(ContaBancaria contaBancaria) {
        return nomeTitular.compareTo(contaBancaria.nomeTitular);
    }
}
