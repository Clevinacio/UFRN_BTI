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

    public int getCount() {
        return count;
    }
}
