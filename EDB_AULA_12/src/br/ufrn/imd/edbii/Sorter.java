package br.ufrn.imd.edbii;

public class Sorter {

    public void heapSort(int[] numeros) {
        //Transforma o array em max heap
        for (int i = numeros.length / 2; i >= 0; --i) {
            heapifyDown(numeros, i, numeros.length);
        }

        //numeros virou uma max heap
        for (int i = numeros.length - 1; i > 0; --i) {
            int tmp = numeros[0];
            numeros[0] = numeros[i];
            numeros[i] = tmp;
            heapifyDown(numeros, 0, i);
        }
    }

    private void heapifyDown(int[] numeros, int index, int length) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int maxIndex = index;

        if (leftChild < length && numeros[leftChild] > numeros[index]) {
            maxIndex = leftChild;
        }

        if (rightChild < length && numeros[rightChild] > numeros[maxIndex]) {
            maxIndex = rightChild;
        }

        if (maxIndex != index) {
            int tmp = numeros[maxIndex];
            numeros[maxIndex] = numeros[index];
            numeros[index] = tmp;
            heapifyDown(numeros,maxIndex, length);
        }


    }
}
