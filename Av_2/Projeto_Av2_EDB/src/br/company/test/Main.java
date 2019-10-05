package br.company.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Huffman huff = new Huffman();
        String str = "lollapalooza";
        huff.characterFrequency(str);
    }
}
