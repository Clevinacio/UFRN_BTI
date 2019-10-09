package br.ufrn.imd.edb2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//      Adiciona verificação de parâmetros escritos no terminal (por enquanto só aceitando um arquivo)
        if (args.length > 0) {
            Huffman huff = new Huffman();
            huff.characterFrequency(args[0]);
        } else {
            String file = "teste.txt";
            Huffman huff = new Huffman();
            huff.characterFrequency(file);
        }


    }
}
