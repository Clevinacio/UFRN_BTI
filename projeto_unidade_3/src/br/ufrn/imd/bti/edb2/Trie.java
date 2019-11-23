package br.ufrn.imd.bti.edb2;

import com.sun.scenario.animation.shared.TimerReceiver;
import sun.java2d.xr.XRRenderer;

import java.util.List;

public class Trie {
    TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        int c = 0;
        TrieNode temp = root;
        TrieNode son = root.getChildren().get((Character) word.charAt(c));
        while (c <= word.length()-1) {
            if (son == null || root.isEmpty()) {
                if (c == word.length()-1) {
                    TrieNode knot = new TrieNode(word);
                    temp.getChildren().put((Character) word.charAt(c), knot);
                    return;
                }
                TrieNode knot = new TrieNode();
                temp.getChildren().put((Character) word.charAt(c), knot);
                temp = temp.getChildren().get((Character) word.charAt(c));
                c++;
            }else {
                c++;
            }
        }
    }

    public void search(String word) {
        int c = 0;
        TrieNode result;
        while (c <= word.length()-1) {
            result = root.getChildren().get(word.charAt(c));

            if (result == null) {
                System.out.println("palavra não existe");
                return;
            }


        }

    }

    public List<String> autoComplete(String arg, String arg1) {

        return null;
    }

    public List<String> autoComplete(String arg) {

        return null;
    }
}
