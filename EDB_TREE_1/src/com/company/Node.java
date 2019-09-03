package com.company;

public class Node {
    private int value;
    private Node left = null;
    private Node right  = null;

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
}
