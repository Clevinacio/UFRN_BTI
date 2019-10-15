package br.ufrn.imd.bti.edb2;

public class ArvoreBinariaBusca<T extends Indexable> {
    private Node<T> raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public Node<T> getRoot() {
        return raiz;
    }

    public void insert(Node<T> node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(T value) {
        Node<T> n = new Node<T>(value);
        insert(n);
    }

    public Node<T> search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

}

