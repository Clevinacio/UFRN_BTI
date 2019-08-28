package com.company;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> childrem;
    private String name;
    private Node daddy = null;

    public Node(String name) {
        this.name = name;
        childrem = new ArrayList<>();
    }

    public Node addChild(String s) {
        Node node = new Node(s);
        return addChild(node);
    }

    public Node addChild(Node node) {
        childrem.add(node);
        node.daddy = this;
        return node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getChildrem() {
        return childrem;
    }

    public boolean isLeaf() {
        return childrem.isEmpty();
    }

    public int nodeDegree() {
        //TODO Calcular o grau de todos os nós filhos
        return childrem.size();
    }

    public int treeDegree() {
        return childrem.size();
    }

    public boolean isSibling(Node other) {
        return this.daddy == other.daddy;
    }
}
