package br.ufrn.imd.edb2;

import java.io.*;
import java.util.*;


public class Huffman {

    HashMap<Character, Integer> mapFrequency;
    Node heapCode;

    public Huffman() {
        mapFrequency = new HashMap<Character, Integer>();
        heapCode = null;
    }

    public HashMap<Character, Integer> getMapFrequency() {
        return mapFrequency;
    }

    public  HashMap<Character, Integer> characterFrequency(String fileName) throws IOException {
        String text = ""; //concatena linhas do arquivo
        int counterBreak = 0; //verifica quebras de linhas

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            text = text.concat(br.readLine());
            counterBreak++;
        }

        char[] strArray = text.toCharArray();

        for (char caracter : strArray) {
            if (mapFrequency.containsKey(caracter)) {
                mapFrequency.put(caracter, mapFrequency.get(caracter) + 1);
            } else {
                mapFrequency.put(caracter, 1);
            }
        }

        //Verifica as quebras de linha e, se houver mais de uma, adiciona ao map
        if (counterBreak > 1) {
            mapFrequency.put((char) 10, counterBreak - 1);
        }

        //ordena o map
        sort();

        return mapFrequency;
    }

    public void heapCode() {
        /* Passo 1 - Criar minHeap e adicionar itens do map */
        MinHeap fila = new MinHeap();
        for (Map.Entry entry : mapFrequency.entrySet()) {
            fila.addNode(new Node((Character) entry.getKey(), (int) entry.getValue()));
        }

        /* Passo 2 - Construir arvore binaria */
        while (fila.getSize() != 1) {
            Node left = fila.remove();
            Node right = fila.remove();

            int count = left.getCount() + right.getCount();
            Node current = new Node('\u0000', count);

            current.setLeft(left);
            current.setRight(right);

            fila.addNode(current);
        }

        System.out.println("Qtd elementos da fila: " + fila.getSize());
        System.out.println("Raiz: " + fila.peek().getCount());

        heapCode = fila.peek();
    }

    public void tableCode () {

    }

    public HashMap<Character, Integer> sort() {
        //Lista com as chaves de map
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(mapFrequency.entrySet());

        //Ordena chaves da maior para menor quantiade de repetições
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> v1, Map.Entry<Character, Integer> v2) {
                if (v1.getValue() > v2.getValue()) {
                    return -1;
                }
                if (v1.getValue() < v2.getValue()) {
                    return 1;
                }
                return 0;
            }
        });

        //Cria hashMap temporário para armazenar o ordenado
        HashMap<Character, Integer> ordered = new LinkedHashMap<Character, Integer>();

        //Salva dados da lista ordenada em ordered
        for (Map.Entry<Character, Integer> item : list) {
            ordered.put(item.getKey(), item.getValue());
        }

        mapFrequency = ordered;

        return ordered;
    }

    public void print(HashMap<Character, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}