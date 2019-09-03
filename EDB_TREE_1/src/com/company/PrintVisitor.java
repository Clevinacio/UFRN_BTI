package com.company;

public class PrintVisitor implements NodeVisitor{

    @Override
    public void visit(Node node) {
        System.out.println(node.getValue());
    }
}
