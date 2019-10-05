package br.company.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Huffman huff = new Huffman();
        String str = "Quando a travessia estiver concluída, atravesse o Hashmap e imprima o caractere e sua frequência.";
        huff.characterFrequency(str);
    }
}
