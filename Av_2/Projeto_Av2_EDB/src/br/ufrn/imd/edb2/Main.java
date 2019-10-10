package br.ufrn.imd.edb2;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
//      Adiciona verificação de parâmetros escritos no terminal (por enquanto só aceitando um arquivo)
        if (args.length > 0) {
            Huffman huff = new Huffman();
            huff.characterFrequency(args[0]);
        } else {
            String file = "teste.txt";
            Huffman huff = new Huffman();

            //Guarda o map que determina o numero de repeticoes de cada char
            huff.characterFrequency(file);

            //O mapa é passado para a arvore de codificacao
            huff.heapCode();

            huff.CodificationTable();

            System.out.println("Frequencia de repeticao dos caracteres: ");
            huff.printMapFrequency();
            System.out.println("");
            System.out.println("Codigo dos caracteres: ");
            huff.printMapCode();
        }
    }
}
