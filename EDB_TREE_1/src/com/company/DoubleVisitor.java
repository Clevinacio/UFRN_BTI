package com.company;

public class DoubleVisitor implements NodeVisitor {
    @Override
    public void visit(Node node) {
        System.out.println(node.getValue()*2);
    }
}
