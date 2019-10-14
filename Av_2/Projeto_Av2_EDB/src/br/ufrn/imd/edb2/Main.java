package br.ufrn.imd.edb2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//      Adiciona verificação de parâmetros escritos no terminal (por enquanto só aceitando um arquivo)
        if (args.length > 0) {
            Compressor huff = new Compressor();
            huff.characterFrequency(args[0]);
        } else {

            String file = "teste5.txt";

            Compressor huff = new Compressor();

            //Determina mapa de frequencia (quantas vezes cada caracter aparece)
            huff.characterFrequency(file);

            //Determina a arvore de codificacao (cada caracter se torna uma folha)
            huff.heapCode();

            //Determina a tabela de codificacao (com base no posicionamento do caracter, é atribuido um codigo)
            huff.CodificationTable();

            System.out.println("Frequencia de repeticao dos caracteres: ");
//            huff.printMapFrequency();
            System.out.println();
            System.out.println("Codigo dos caracteres: ");
//            huff.printMapCode();

            //Codifica o texto
            huff.codeText();

            Extractor ex = new Extractor("symbolTable.edt");
            ex.makeCodificationTable();
            ex.makeBitSet();
        }
    }
}
