package br.ufrn.imd.bti.edb2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Trie t = new Trie();
        BufferedReader br;
        if (args.length > 0) {
            try {
                br = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
                return;
            }

            while (br.ready()) {
                t.insert(br.readLine());
            }
            if (args.length == 3) {
                List<String> words = t.autoComplete(args[1], Integer.parseInt(args[2]));
                if (words == null) {
                    System.out.println("Nenhuma palavra encontrada");
                    return;
                }

                for (String word : words) {
                    System.out.println(word);
                }
                return;
            }
            if (args.length == 2) {
                List<String> words = t.autoComplete(args[1]);
                if (words == null) {
                    System.out.println("Nenhuma palavra encontrada");
                    return;
                }

                for (String word : words) {
                    System.out.println(word);
                }
                return;
            } else {
                System.out.println("Falta argumentos");
                return;
            }

        } else {
            System.out.println("Nenhum argumento passado. Abrindo interface gráfica");
            try {
                br = new BufferedReader(new FileReader("palavras.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo de palavras não encontrado. Encerrando");
                return;
            }

            while (br.ready()) {
                t.insert(br.readLine());
            }

            InterfaceComplete ic = new InterfaceComplete(t);
        }
    }
}
