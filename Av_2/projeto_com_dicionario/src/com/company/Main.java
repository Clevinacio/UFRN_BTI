package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Main {

    public static void main(String[] args) throws IOException,FileNotFoundException, NoSuchFileException {
        Compressor c;
        Extractor ex;
        if (args.length > 0) {
            if (args[0].equals("compress")) {
                c = new Compressor(args[1]);
                try {
                    c.CompressTextToFile(args[2]);
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo não encontrado");
                    return;
                }

                try {
                    c.porcent(args[2]);
                } catch (ArithmeticException e) {
                    System.out.println("Arquivo vazio. Mesmo tamanho do original");
                }

            } else if (args[0].equals("extract")) {
                ex = new Extractor();
                try {
                    ex.makeBitSet(args[1]);
                } catch (FileNotFoundException e) {
                    System.out.println("Nome do arquivo comprimido inválido");
                    return;
                }

                ex.convertBitSetToString(args[2]);

            } else {
                System.out.println("Comando inválido");
            }
        } else {
            System.out.println("Nenhum argumento passado");

            /*Compressor c = new Compressor("resources/dicionario.txt");
            c.CompressTextToFile("dicionario.edz");
            c.porcent("dicionario.edz");*/

            /*System.out.println("1");
            Extractor e = new Extractor("dicionario.edt");
            e.makeCodificationTable();
            System.out.println("2");
            e.makeBitSet("dicionario.edz");
            System.out.println("3");
            e.convertBitSetToString("dic.txt");
            System.out.println("4");*/
        }
    }
}
