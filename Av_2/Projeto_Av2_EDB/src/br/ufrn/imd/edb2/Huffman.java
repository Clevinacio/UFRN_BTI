package br.ufrn.imd.edb2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Huffman {
    //Coloquei pra retornar uma hashmap para poder fazer o teste
    public HashMap<Character, Integer> characterFrequency(String fileName) throws IOException {
        //Adiciona leitura de arquivo para contagem
        String text = "";

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        while (br.ready()) {
            text = text.concat(br.readLine());
        }
        //Termina aqui

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
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return map;

    }


}
