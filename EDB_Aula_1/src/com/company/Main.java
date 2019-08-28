package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(20);
        l.insert(30);
        l.insert(40);

        Node current = l.getRoot();

        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

    }
}
