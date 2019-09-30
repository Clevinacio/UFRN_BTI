package br.com.waldson.aula11;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public Node getRoot() {
        return raiz;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

    public boolean isBalanced() {
        if (raiz.height(raiz.getLeft()) >= raiz.height(raiz.getRight())) {
            return raiz.height(raiz.getLeft()) - raiz.height(raiz.getRight()) <= 1;
        }

        if (raiz.height(raiz.getLeft()) <= raiz.height(raiz.getRight())) {
            return raiz.height(raiz.getRight()) - raiz.height(raiz.getLeft()) <= 1;
        }
        return false;
    }

}
