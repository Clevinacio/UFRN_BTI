package br.ufrn.imd.bti.edb2;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(new Pessoa(3));
        tree.insert(new Pessoa(2));
        tree.insert(new Pessoa(1));
        tree.insert(new Pessoa(4));
        tree.insert(new Pessoa(5));
        tree.insert(new Pessoa(6));
        tree.insert(new Pessoa(7));
    }
}
