package br.ufrn.imd.edb2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Extractor {

    private HashMap<String, Character> mapCodeTable;
    private String fileName;

    public Extractor(String fileName){
        this.mapCodeTable = new HashMap<String, Character>();
        this.fileName = fileName;
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
}
