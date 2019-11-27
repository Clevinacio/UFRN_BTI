package br.ufrn.imd.bti.edb2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Trie t = new Trie();
        BufferedReader file = new BufferedReader(new FileReader("palavras.txt"));

        while (file.ready()) {
            t.insert(file.readLine());
        }

        System.out.println("Search: "+t.search("a"));

        List<String> results = t.autoComplete("a");

        if (results == null) {
            System.out.println("Deu erro boy");
            return;
        }
        for (String word : results) {
            System.out.println(word);
        }

//        BufferedReader br;
//        String lineRead;
//        if (args.length > 0) {
//            try {
//                br = new BufferedReader(new FileReader(args[0]));
//            } catch (FileNotFoundException e) {
//                System.out.println("Aruivo não encontrado");
//                return;
//            }
//
//            while (br.readLine() != null) {
//                lineRead = br.readLine();
//                t.insert(lineRead);
//            }
//
//        List<String> words = t.autoComplete(args[1], Integer.parseInt(args[2]));
//
//            for (String word : words) {
//                System.out.println(word);
//            }
//
//        } else {
//            System.out.println("Nenhum argumento passado");
//        }
    }
}
