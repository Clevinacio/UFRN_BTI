package banco;

import java.util.ArrayList;

public class Banco implements Imprimivel{
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<ContaBancaria>();
    }

    public boolean inserir(ContaBancaria conta) {
        if (contas.contains(conta)) {
            System.out.println("Conta já existe");
            return false;
        }

        contas.add(conta);
        System.out.println("Conta criada");
        return true;
    }

    public boolean remover(ContaBancaria conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            System.out.println("Conta removida");
            return true;
        }

        System.out.println("Deu merda!");
        return false;
    }

    public ContaBancaria procurarConta(int numeroConta) {
        for (ContaBancaria c : contas) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }

        return null;
    }

    @Override
    public void mostrarDados() {

        for (ContaBancaria c : contas) {
            if (c instanceof ContaPoupanca) {
                ((ContaPoupanca) c).mostrarDados();
            }else {
                ((ContaCorrente) c).mostrarDados();
            }
        }
    }
}
