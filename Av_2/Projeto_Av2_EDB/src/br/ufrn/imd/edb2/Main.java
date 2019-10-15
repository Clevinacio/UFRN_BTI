package br.ufrn.imd.edb2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            if (args[0].equals("compress")) {
                Compressor c = new Compressor();
                c.characterFrequency(args[1]);
                c.heapCode();
                c.CodificationTable();
                c.codeText(args[2], args[3]);
            }
            if (args[0].equals("extract")) {
                Extractor ex = new Extractor(args[2]);
                ex.makeCodificationTable();
                ex.makeBitSet(args[1]);
                ex.convertBitSetToString(args[3]);

            }
            
        } else {
            System.out.println("Nenhum argumento passado");

/*
            Extractor ex = new Extractor("symbolTable.edt");
            ex.makeCodificationTable();
            ex.makeBitSet();
            ex.convertBitSetToString();
*/
        }
    }
}
