package br.com.waldson.aula11;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public Node(int value) {
        this.value = value;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }

    public int height(Node node) {
        int height = -1;
        
        if (node == null) {
            return height;
        }

        if (node.getRight() == null && node.getLeft() == null) {
            return height;
        }

        if (node.getRight() != null) {
            height = 1 + height(node.getRight());
        }

        if (node.getLeft() != null) {
            height = 1 + height(node.getLeft());
        }

        return height;
    }
}
