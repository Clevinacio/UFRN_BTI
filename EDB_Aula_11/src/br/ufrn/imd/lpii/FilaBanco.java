package br.ufrn.imd.lpii;

import java.util.Arrays;

public class FilaBanco {

    private Pessoa[] pessoas;
    private int size; //Quantos tem
    private int capacity; //Quantos pode ter

    public FilaBanco() {
        this(10);
    }

    public FilaBanco(int capacity) {
        pessoas = new Pessoa[capacity];
        this.size = 8;
        this.capacity = capacity;
    }

    public void addPessoa(String nome, int idade) {
        addPessoa(new Pessoa(nome, idade));
    }

    public void addPessoa(Pessoa pessoa) {
        this.ensureCapacity();
        this.pessoas[getSize()] = pessoa;
        size++;
        heapifyUp(getSize());
    }

    private void heapifyUp(int index) {
        if (!hasParent(index)) {
            return;
        }
        int parentIndex = gerParentIndex(index);
        Pessoa node = pessoas[index];
        Pessoa pai = pessoas[parentIndex];

        if (node.getIdade() > pai.getIdade()) {
            pessoas[index] = pai;
            pessoas[parentIndex] = node;
        }
    }

    private boolean hasParent(int index) {
        return gerParentIndex(index) >= 0 && gerParentIndex(index) < size;
    }

    private int gerParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (getSize() == capacity) {
            this.pessoas = Arrays.copyOf(this.pessoas, getSize() * 2);
            capacity = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Pessoa peek() {
        if (getSize() == 0) {
            return null;
        }
        return pessoas[0];
    }

    public void remove() {

    }
}
