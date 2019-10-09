package br.ufrn.imd.edb2;

import java.util.Arrays;

public class MinHeap {
    private Node [] node;
    private int size; //quantos elementos tem
    private int capacity; //quantos elementos pode ter

    public MinHeap() {
        this(10);
    }

    public MinHeap(int capacity) {
        node = new Node[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void addNode(Character letter, int count) {
        addNode(new Node(letter, count));
    }

    public void addNode(Node node) {
        this.ensureCapacity();
        this.node[getSize()] = node;
        heapfyUp(getSize());
        size++;
    }

    private void heapfyUp (int index) {
        if (!hasParent(index)) {
            return;
        }

        int parentIndex = getParendIndex(index);

        Node current = node[index];
        Node pai = node[parentIndex];

        if (current.getCount() < pai.getCount()) {
            node[index] = pai;
            node[parentIndex] = current;
            heapfyUp(parentIndex);
        }
    }

    private boolean hasParent (int index) {
        return getParendIndex(index) >= 0 && getParendIndex(index) < size;
    }

    private int getParendIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (getSize() == capacity) {
            this.node = Arrays.copyOf(this.node, getSize() * 2);
            capacity = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return node[0];
    }

    public void remove() {
        node[0] = node[getSize() - 1];
        node[getSize() - 1] = null;
        size--;
        heapfyDown(0);
    }

    private void heapfyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;

        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex < 0) {
            return;
        }

        if (rightChild < getSize()) {
            if (node[rightChild].getCount() < node[leftChild].getCount()) {
                childIndex = rightChild;
            }
        }

        if (node[index].getCount() > node[childIndex].getCount()) {
            Node tmp = node[index];
            node[index] = node[childIndex];
            node[childIndex] = tmp;
            heapfyDown(childIndex);
        }
    }

    public void print(){
        for (int i = 0; i < getSize(); i++) {
            System.out.println(node[i].getCount());
        }
    }
}
