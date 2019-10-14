package br.ufrn.imd.edb2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Extractor {

    private HashMap<String, Character> mapCodeTable;
    private BitSet codedText;
    private String fileName;

    public Extractor(String fileName){
        this.mapCodeTable = new HashMap<String, Character>();
        this.fileName = fileName;
        codedText = new BitSet();
    }

    /*
        Cria tabela de codificacao a partir do arquivo informado
     */
    public void makeCodificationTable () throws IOException {
        char[] charArray;                   //array para guardar cada linha do arquivo
        char letter = '0';                  //guarda caracter ao qual o codigo se refere
        String code = "";                   //guarda o codigo para o caracter
        int position = 0;                   //utilizado para verificacao da primeira posicao do array

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            charArray = br.readLine().toCharArray();
            position = 0;
            code = "";
            for (char caracter : charArray) {           //percorrer os caracteres de cada linha
                if (position == 0) {                    //o primeiro caracter refere-se a letra
                    letter = caracter;
                    position++;
                }else{                                  //demais posicoes referem-se ao codigo
                    code = code + caracter;
                }
            }

            mapCodeTable.put(code, letter);             //o codigo e o caracter sao adicionados ao dicionario
        }
    }

    /*
        Cria BitSet a partir do arquivo codificado
     */
    public void makeBitSet() throws IOException {
        byte[] array = Files.readAllBytes(Paths.get("convert.edz"));                //guarda todos os byste do arquivo em um array

//        System.out.println("Imprime o array de bytes");
//        for (byte b : array) {
//            System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1));
//        }
//        System.out.println("");

        BitSet temp = new BitSet();                                                  //converte os bytes para BitSet temporario
        for (int i = 0; i < array.length * 8; i++) {
            if ((array[array.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
                temp.set(i);
            }
        }

        for(int i = 0; i < temp.length(); i++){                                      //inverte a ordem do BitSet temporario e armazena no BitSet da classe
            this.codedText.set(i, temp.get(temp.length() - i - 1));
        }

//        System.out.println("Imprime o BitSet");
//        String value = "";
//        for (int i = 0; i < codedText.length(); i++) {
//            if(codedText.get(i) == false) {
//                value += "0";
//            }else{
//                value += "1";
//            }
//        }
//        System.out.println(value);
    }
}
