package com.company;

public class Main {

    public static void main(String[] args) {

        ArvoreBuscaBinaria av = new ArvoreBuscaBinaria();

        av.insert(15);
        av.insert(25);
        av.insert(5);
        av.insert(35);

        Node n = av.search(35);
        if (n != null) {
            System.out.println("AChou");
        }else {
            System.out.println("Não achou");
        }


    }
}
