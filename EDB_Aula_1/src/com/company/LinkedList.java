package com.company;

public class LinkedList {
    private Node root;

    public void insert(int value){
        Node n = new Node(value);

        if (root == null) {
            root = n;
            return;
        }

        Node current = this.getRoot();
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(n);
    }

    public Node getRoot() {
        return root;
    }
}
