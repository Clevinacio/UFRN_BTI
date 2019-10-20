package com.company;

import java.io.*;
import java.util.*;

public class Compressor {

    private HashMap<Character, String> mapCodeTable;
    private String fileName;

    public Compressor(String fileName) throws IOException {
        mapCodeTable = new HashMap<Character, String>();
        makeCodificationMap();
        this.fileName = fileName;
    }

    public Compressor() {
        mapCodeTable = new HashMap<Character, String>();
    }

    public HashMap<Character, String> getMapCodeTable() {
        return mapCodeTable;
    }

    public void makeCodificationMap() throws IOException {
        char[] charArray;                   //array para guardar cada linha do arquivo
        char letter = '0';                  //guarda caracter ao qual o codigo se refere
        String code = "";                   //guarda o codigo para o caracter
        int position = 0;                   //utilizado para verificacao da primeira posicao do array
        InputStream is = getClass().getResourceAsStream("/dicionario.edt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

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

            mapCodeTable.put(letter, code);             //o codigo e o caracter sao adicionados ao dicionario
        }
    }

    public void CompressTextToFile(String outPutFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        BitSet txtCode = new BitSet();
        String code;
        int charCurrent = 0;
        int position = 0;

        while ((charCurrent = br.read()) != -1) {                    //leitura char - char no arquivo
            if (charCurrent == (char)10) {                           //Se for uma quebra de linha, busca pelo codigo predeterminado
                code = mapCodeTable.get((char) 280);
            } else {
                code = mapCodeTable.get((char) charCurrent);         //senao, busca pelo codigo do caracter corrente
            }

          /*Se náo encontrar o código no map, o retorno será null. Isso ocorre quando
            o SO reconhece o /r/n. Só está sendo adicionado o codigo do /n.*/
            if (code == null) {
                continue;
            }

            for (int i = 0; i < code.length(); i++) {       //percorre caracteres do codigo
                if (code.charAt(i) == '1') {
                    txtCode.set(position, true);            //atribui valor 1 no bitset
                }
                position++;
            }
        }

        code = mapCodeTable.get((char) 300);            //Busca EOF
        for (int i = 0; i < code.length(); i++) {       //Adiciona ao binario
            if (code.charAt(i) == '1') {
                txtCode.set(position, true);
            }
            position++;
        }

        while (position % 8 != 0) {                    //para que seja multiplo de 8, as posicioes que sobrarem depois do EOF sao preenchidas com 1
            txtCode.set(position, true);
            position++;
        }

        OutputStream os = new FileOutputStream(new File(outPutFile));
        os.write(convertBitSetToArray(txtCode));
        os.close();
    }

    private byte[] convertBitSetToArray(BitSet txtCode) {
        byte[] bytes = new byte[(txtCode.length() + 7) / 8];
        for (int i = 0; i < txtCode.length(); i++) {
            if (txtCode.get(i)) {
                bytes[i / 8] |= 1 << (7 - i % 8);
            }
        }
        return bytes;
    }

    public void porcent(String fileConvert) {
        File fileBinary = new File(fileConvert);
        File fileTxt = new File(this.fileName);
        float porcent = (fileBinary.length() * 100)/fileTxt.length();
        System.out.printf("arquivo foi possui %.1f%% do seu tamanho original\n", porcent);
    }
}