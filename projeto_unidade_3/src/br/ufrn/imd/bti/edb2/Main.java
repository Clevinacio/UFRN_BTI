package br.ufrn.imd.bti.edb2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Trie t = new Trie();
        String word = "amar";
        String word1 = "amor";
        t.insert(word);
        t.insert(word1);
        char key = 'a';
        System.out.println(key+" "+t.getRoot().getChildren().get(key).getChildren().get('m').getChildren().get('o').getChildren().get('r').isWord());
        System.out.println(key+" "+t.getRoot().getChildren().get(key).getChildren().get('m').getChildren().get('o').getChildren().get('r').isEmpty());



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
//            List<String> words = t.autoComplete(args[1],args[2]);
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
