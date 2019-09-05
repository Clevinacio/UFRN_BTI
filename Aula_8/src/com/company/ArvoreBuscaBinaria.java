package com.company;

public class ArvoreBuscaBinaria {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        if (root.getValue() < node.getValue()) {
            if (root.getRight() == null) {
                root.setRight(node);
            }else{
                root.getRight().insert(node);
            }
        }else if (root.getValue() > node.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            }else{
                root.getLeft().insert(node);
            }
        }
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int i) {
        if (root == null) {
            return null;
        }

        return root.search(i);
    }
}
