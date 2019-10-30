package br.ufrn.imd.bti.edb2;

public class RedBlackNode<T extends Comparable<T>> {
    private T value;
    private RedBlackNode<T> parent = null;
    private RedBlackNode<T> left = null;
    private RedBlackNode<T> rigt = null;
    private  NodeColor color;

    public RedBlackNode(T value) {
        this.value = value;
        this.color = NodeColor.Red;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public RedBlackNode<T> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<T> left) {
        this.left = left;
    }

    public RedBlackNode<T> getRigt() {
        return rigt;
    }

    public void setRigt(RedBlackNode<T> rigt) {
        this.rigt = rigt;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }
}
