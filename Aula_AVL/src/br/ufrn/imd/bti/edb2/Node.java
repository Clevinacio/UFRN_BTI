package br.ufrn.imd.bti.edb2;

public class Node<T extends Indexable> {
    private Node<T> left;
    private Node<T> right;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void insert(Node<T> node) {
        if (node.value.getKey() < this.value.getKey()) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value.getKey() > this.value.getKey()) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value.getKey()) {
            return this;
        }

        if (key < this.value.getKey()) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value.getKey()) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }
}
