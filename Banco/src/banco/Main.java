package banco;

public class Main {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(1254546, 10);
        ContaPoupanca cp = new ContaPoupanca(1231545, 200);
        Banco b = new Banco();

        b.inserir(cc);
        b.inserir(cp);

        b.remover(cp);
        b.remover(cp);

//        cc.depositar(200);
//        cp.depositar(150);
//
//        cc.sacar(50);
//        cp.sacar(300);
//
//        Relatorio r = new Relatorio();
//
//        r.gerarRelatorio(cc);
//        r.gerarRelatorio(cp);
//
//        cc.transferir(100,cp);

        b.mostrarDados();
    }
}
