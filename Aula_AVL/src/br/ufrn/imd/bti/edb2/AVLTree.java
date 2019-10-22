package br.ufrn.imd.bti.edb2;

public class AVLTree<Type extends Indexable> {
    private Node<Type> root;

    public void insert(Type value) {
        root = insert(new Node<Type>(value), root);
    }

    private Node<Type> insert(Node<Type> node, Node<Type> parent) {
        if (parent == null) {
            return node;
        }

        if (node.getValue().getKey() == parent.getValue().getKey()) {
            parent.setValue(node.getValue());
            return parent;
        }

        if (node.getValue().getKey() < parent.getValue().getKey()) {
            parent.setLeft(insert(node, parent.getLeft()));
        }else {
            parent.setRight(insert(node, parent.getRight()));
        }

        return balance(parent);
    }

    private Node<Type> balance(Node<Type> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor >= -1 && balanceFactor <= 1) {
            return node;
        }

        if (balanceFactor > 1) {
            //L
            if (node.getLeft().getBalanceFactor() > 0) {
                //LL
                return rotateRight(node);
            } else {
                //LR
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }

        } else {
            //R
            if (node.getRight().getBalanceFactor() < 0) {
                //RR
                return rotateLeft(node);
            } else {
                //RL
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }

        }

        return null;
    }

    private Node<Type> rotateRight(Node<Type> node) {
        Node<Type> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);

        return newRoot;
    }

    private Node<Type> rotateLeft(Node<Type> node) {
        Node<Type> newRoot = node.getRight();
        node.setRight(newRoot.getRight());
        newRoot.setLeft(node);

        return newRoot;
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }

        return Math.abs(root.getBalanceFactor() <= 1);
    }

}
