package br.ufrn.imd.lpii;

public class Main {

    public static void main(String[] args) {
        //Heap / Priority Queue
        FilaBanco fila = new FilaBanco();
        fila.addPessoa("Fulano", 20);
        fila.addPessoa("Beltrano", 10);
        fila.addPessoa("Vovó", 64);
        fila.addPessoa("Zé", 50);
        fila.addPessoa(new Pessoa("Cláudia", 5));
        Pessoa p1 = new Pessoa("Clev", 20);

        System.out.println(fila.peek().getNome());

        fila.addPessoa(p1);

        p1.setIdade(90);

        System.out.println(fila.peek().getNome());

        /*while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println(p.getNome() + " está sendo atendido.");
            fila.remove();
        }*/


    }
}
