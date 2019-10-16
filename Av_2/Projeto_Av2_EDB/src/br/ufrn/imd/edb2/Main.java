package br.ufrn.imd.edb2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Main {

    public static void main(String[] args) throws IOException,FileNotFoundException, NoSuchFileException {
        Compressor c = null;
        Extractor ex;
        if (args.length > 0) {
            if (args[0].equals("compress")) {
                c = new Compressor(args[1]);
                try {
                c.characterFrequency();
                } catch (FileNotFoundException e) {
                    System.out.println("Nome do arquivo de entrada inválido");
                    return;
                }

                c.heapCode();
                c.makeCodificationTable();
                c.CompressTextToFile(args[2], args[3]);
                c.porcent(args[2]);

            } else if (args[0].equals("extract")) {
                ex = new Extractor(args[2]);
                try {
                    ex.makeCodificationTable();
                } catch (FileNotFoundException e) {
                    System.out.println("Nome do arquivo da tabela de codificação inválido");
                    return;
                }

                try {
                    ex.makeBitSet(args[1]);
                } catch (NoSuchFileException e) {
                    System.out.println("Nome do arquivo comprimido inválido");
                    return;
                }

                ex.convertBitSetToString(args[3]);

            } else {
                System.out.println("Comando inválido");
            }

            
        } else {
            System.out.println("Nenhum argumento passado");
        }
    }
}
