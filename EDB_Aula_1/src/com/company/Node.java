package com.company;

public class Node {
    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    private int value;
    private Node next;

    public int getValue() {
        return value;
    }

    public Node(int value) {
        this.value = value;
    }
}
