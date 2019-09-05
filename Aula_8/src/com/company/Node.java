package com.company;

public class Node {
    private int value;
    private Node left = null;
    private Node right  = null;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node(int i) {
        this.value = i;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void accessPreOrder(NodeVisitor v) {
        v.visit(this);
        if (this.left != null) {
            this.left.accessPreOrder(v);
        }

        if (this.right != null) {
            this.right.accessPreOrder(v);
        }
    }

    public void accessinOrder(NodeVisitor v) {

        if (this.left != null) {
            this.left.accessPreOrder(v);
        }

        v.visit(this);

        if (this.right != null) {
            this.right.accessPreOrder(v);
        }
    }

    public void accessPostOrder(NodeVisitor v) {

        if (this.left != null) {
            this.left.accessPreOrder(v);
        }

        if (this.right != null) {
            this.right.accessPreOrder(v);
        }

        v.visit(this);
    }

    public int getValue() {
        return value;
    }

    public Node search(int i) {
        if (i == this.value) {
            return this;
        }
        if (i < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(i);
        }

        if (i > this.value) {
            if (right == null) {
                return null;
            }
            return right.search(i);
        }
        return null;
    }

    public void insert(Node node) {
        if (this.value > node.value) {
            if (left == null) {
                left = node;
            }
            left.insert(node);
        } else if (this.value < node.value) {
            if (right == null) {
                right = node;
            }
            right.insert(node);
        }
    }
}
