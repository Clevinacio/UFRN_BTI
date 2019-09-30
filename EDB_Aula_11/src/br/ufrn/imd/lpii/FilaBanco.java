package br.ufrn.imd.lpii;
import java.util.Arrays;

public class FilaBanco implements CatchEvent {

    private Pessoa [] pessoas;
    private int size; //quantos elementos tem
    private int capacity; //wuantos elementos pode ter

    public FilaBanco () {
        this(10);
    }

    public FilaBanco (int capacity) {
        pessoas = new Pessoa[capacity];
        this.capacity = capacity;
        this.size = 0;
    }


    public void addPessoa(String nome, int idade) {
        addPessoa(new Pessoa(nome, idade));
    }

    public void addPessoa(Pessoa pessoa) {
        this.ensureCapacity();
        this.pessoas[getSize()] = pessoa;
        pessoa.addCatchEvent(this);
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        if (!hasParent(index)) {
            return;
        }

        int parentIndex = getParentIndex(index);

        Pessoa node = pessoas[index];
        Pessoa pai = pessoas[parentIndex];

        if (node.getIdade() > pai.getIdade()) {
            pessoas[index] = pai;
            pessoas[parentIndex] = node;
            heapifyUp(parentIndex);
        }
    }

    private boolean hasParent (int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {
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
        pessoas[0] = pessoas[this.getSize() - 1];
        pessoas[getSize() - 1].removeCatchEvent(this);
        pessoas[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int ChildIndex = -1;
        if (leftChild < getSize()) {
            ChildIndex = leftChild;
        }

        if (ChildIndex < 0) {
            return;
        }

        if (rightChild < getSize()) {
            if (pessoas[rightChild].getIdade() > pessoas[leftChild].getIdade()) {
                ChildIndex = rightChild;
            }
        }

        if (pessoas[index].getIdade() < pessoas[ChildIndex].getIdade()) {
            Pessoa tmp = pessoas[index];
            pessoas[index] = pessoas[ChildIndex];
            pessoas[ChildIndex] = tmp;
            heapifyDown(ChildIndex);
        }

    }

    @Override
    public void capture(Pessoa p, int old) {
        int index = -1;
        for (int i = 0; i < getSize(); i++) {
            if (pessoas[i].getNome() == p.getNome()) {
                index = i;
                break;
            }
        }
        if (p.getIdade() > old) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

}