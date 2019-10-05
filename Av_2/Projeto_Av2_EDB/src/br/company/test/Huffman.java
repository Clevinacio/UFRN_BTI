package br.company.test;

import java.util.HashMap;
import java.util.Map;

public class Huffman {
    public void characterFrequency(String text){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char[] strArray = text.toCharArray();

        for (char caracter : strArray) {
            if (map.containsKey(caracter)) {
                map.put(caracter, map.get(caracter) + 1);
            }
            else {
                map.put(caracter, 1);
            }
        }

        // Mostra na tela
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}
