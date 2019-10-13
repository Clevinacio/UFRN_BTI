package br.ufrn.imd.edb2;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
//      Adiciona verificação de parâmetros escritos no terminal (por enquanto só aceitando um arquivo)
        if (args.length > 0) {
            Huffman huff = new Huffman();
            huff.characterFrequency(args[0]);
        } else {

            String file = "teste1.txt";

            Huffman huff = new Huffman();

            //Determina mapa de frequencia (quantas vezes cada caracter aparece)
            huff.characterFrequency(file);

            //Determina a arvore de codificacao (cada caracter se torna uma folha)
            huff.heapCode();

            //Determina a tabela de codificacao (com base no posicionamento do caracter, é atribuido um codigo)
            huff.CodificationTable();

            System.out.println("Frequencia de repeticao dos caracteres: ");
            huff.printMapFrequency();
            System.out.println("");
            System.out.println("Codigo dos caracteres: ");
            huff.printMapCode();

            //Codifica o texto
            huff.codeText();
        }
    }
}
