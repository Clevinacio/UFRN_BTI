package br.ufrn.imd.bti.edb2;

public class RedBlackTree<T extends Comparable<T>> {
    private RedBlackNode<T> root;

    private RedBlackNode<T> insert(RedBlackNode<T> node, RedBlackNode<T> parent) {
        if (parent == null) {
            return node;
        }

        if (node.getValue().getKey() == parent.getValue().getKey()) {
            parent.setValue(node.getValue());
            return parent;
        }

        if (node.getValue().getKey() < parent.getValue().getKey()) {
            parent.setLeft(insert(node, parent.getLeft()));
        } else {
            parent.setRight(insert(node, parent.getRight()));
        }

        return balance(parent);
    }
}
