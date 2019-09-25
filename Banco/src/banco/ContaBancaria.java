package banco;

public abstract class ContaBancaria {
    protected int numeroConta;
    protected double saldoConta;

    public ContaBancaria(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldoConta = 0;
    }

    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);
    public abstract boolean transferir(double valor, ContaBancaria destino);

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    protected void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
}
