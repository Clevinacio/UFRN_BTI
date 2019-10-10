package br.ufrn.imd.edb2;

public class Node {
    private Character letter;
    private int count;
    private Node left;
    private Node right;

    public Node (Character letter, int count){
        this.left = null;
        this.right = null;
        this.letter = letter;
        this.count = count;
    }

    public Character getLetter() {
        return letter;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }
}
