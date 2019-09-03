package com.company;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(5));
        root.setRight(new Node(30));
        root.setValue(20);

        PrintVisitor p = new PrintVisitor();



        System.out.println("Pré-Ordem");
        root.accessPreOrder(p);

        System.out.println("Em Ordem");
        root.accessPreOrder(p);

        System.out.println("Pós-Ordem");
        root.accessPreOrder(p);

    }
}
