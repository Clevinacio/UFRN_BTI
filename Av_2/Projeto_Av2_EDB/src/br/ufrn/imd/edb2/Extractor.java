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
    private char EOF;
    private int breakLine;

    public Extractor(String fileName){
        this.mapCodeTable = new HashMap<String, Character>();
        this.fileName = fileName;
        this.codedText = new BitSet();
        this.EOF = (char) 300;
        this.breakLine = 280;
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
//
//        System.out.println("Imprime o array de bytes");
//        for (byte b : array) {
//            System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1));
//        }
//        System.out.println("");
//        System.out.println(array.length);
//        System.out.println();

        BitSet temp = new BitSet();                                                  //converte os bytes para BitSet temporario
        for (int i = 0; i < array.length * 8; i++) {
            if ((array[array.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
                temp.set(i);
            }
        }

//        verifica se todos os bits foram passados
        int resto = temp.length() % 8;
        int valor;
        if (resto == 0) {
            valor = 0;
        }else{
            valor = 8 - resto;
        }

        for(int i = 0; i < temp.length(); i++){                                      //inverte a ordem do BitSet temporario e armazena no BitSet da classe
            this.codedText.set(i+valor, temp.get(temp.length() - i - 1));
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
//
//        System.out.println(codedText.length());
//        System.out.println(value);
    }

    /*
        Converte BitSet em String - (decodificacao)
     */
    public void convertBitSetToString () throws FileNotFoundException {
        String buffer = "";                                         //Guarda texto decodificado
        String code = "";                                           //Guarda codigo para busca no map
        char letter;                                                //Guarda resultado do map

//        System.out.println(this.codedText.length());
        for (int i = 0; i < this.codedText.length(); i++) {         //Percorre BitSet
            if(codedText.get(i) == false) {
                code += "0";
            }else{
                code += "1";
            }

            if (mapCodeTable.get(code) != null) {                   //Se nao encontrar referencia no map (null) devecontinuar adicionando bits em code
                letter = mapCodeTable.get(code);                    //Caso encontre, o caracter é guardado
                if (letter == this.EOF) {                                //É feira a verificacao se o caracter é o EOF
                    break;
                }

                if (letter == (char)breakLine) {                         //Se não for o EOF, verifica quebra de linhas
                    buffer = buffer + "\n";
                } else {
                    buffer = buffer + letter;
                }
                code = "";
            }
        }

        PrintWriter writer = new PrintWriter("arquivo.txt");
        writer.println(buffer);
        writer.close();
    }
}
