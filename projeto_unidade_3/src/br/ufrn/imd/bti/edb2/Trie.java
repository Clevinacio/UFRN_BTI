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
        TrieNode son = temp.getChildren().get((Character) word.charAt(c));
        while (c <= word.length()-1) {
            if (son == null || temp.isEmpty()) {
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
                temp = temp.getChildren().get((Character) word.charAt(c));
                son = temp.getChildren().get((Character) word.charAt(c));
                c++;
            }
        }
    }

    public TrieNode search(String word) {
        int c = 0;
        TrieNode temp = root;
        while (c <= word.length()-1) {
            TrieNode result = temp.getChildren().get(word.charAt(c));
            if (result == null) {
                System.out.println("palavra não existe");
                 return null;
            }

            if (result.isWord() && result.getWord().equals(word)) {
                return result;
            }
            c++;
            temp = result;
        }
        System.out.println("Palavra não existe");
        return null;
    }

    public boolean remove(String word) {
        TrieNode result = search(word);
        if (result == null) {
            System.out.println("Palavra não existe");
            return false;
        }

        return false;
    }

    public List<String> autoComplete(String prefix, int quantity) {

        return null;
    }

    public List<String> autoComplete(String arg) {

        return null;
    }
}
