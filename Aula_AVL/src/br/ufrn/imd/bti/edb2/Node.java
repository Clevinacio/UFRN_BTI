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

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
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

    public int getBalanceFactor() {
        int leftHeight = getLeft() == null ? 0 : 1 + getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : 1 + getRight().getHeight();

        return leftHeight - rightHeight;
    }

    private int getHeight() {
        if (getLeft() == null && getRight() == null) {
            return 0;
        }
        if (getLeft() == null) {
            return 1 + getRight().getHeight();
        }
        if (getRight() == null) {
            return 1 + getLeft().getHeight();
        }
        return Math.max(1 + getLeft().getHeight(), 1 + getRight().getHeight());
    }
}
