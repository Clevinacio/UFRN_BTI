package br.ufrn.imd.edb2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Huffman {
    public HashMap<Character, Integer> characterFrequency(String fileName) throws IOException {
        String text = "";
        int counterBreak = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        while (br.ready()) {
            text = text.concat(br.readLine());
            counterBreak++;
        }

        char[] strArray = text.toCharArray();

        for (char caracter : strArray) {
            if (map.containsKey(caracter)) {
                map.put(caracter, map.get(caracter) + 1);
            }
            else {
                map.put(caracter, 1);
            }
        }

//        map.put((char)10,counterBreak);

        // Mostra na tela
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("");

        return map;
    }

    public void heapCode(HashMap<Character, Integer> map) {

        /* Passo 1 - Criar minHeap e adicionar itens do map*/
        MinHeap fila = new MinHeap();
        for (Map.Entry entry : map.entrySet()) {
            fila.addNode(new Node((Character)entry.getKey(), (int)entry.getValue()));
        }

        fila.print(); //Verifica como ficou a fila
    }
}
