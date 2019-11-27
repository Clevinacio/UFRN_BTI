package br.ufrn.imd.bti.edb2;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public boolean search(String word) {
        int c = 0;
        TrieNode temp = root;
        while (c <= word.length()-1) {
            TrieNode result = temp.getChildren().get(word.charAt(c));
            if (result == null) {
                 return false;
            }

            if (result.isWord() && result.getWord().equals(word)) {
                return true;
            }
            c++;
            temp = result;
        }
        return false;
    }

    public List<String> autoComplete(String prefix) {
        List<String> results = new ArrayList<String>();
        List<TrieNode> knots = new ArrayList<>();
        int c = 0;
        TrieNode temp = root;
        TrieNode result = null;

        while (c <= prefix.length() - 1) {
            result = temp.getChildren().get(prefix.charAt(c));
            if (result == null) {
                return null;
            }

            if (c == prefix.length() - 1) {
                break;
            }
            temp = result;
            c++;
        }

        knots.add(result);
//        System.out.println(result.getChildren().get('a').isEmpty());

        getAllWords(results, knots);

        return results;
    }

    private void getAllWords(List<String> results, List<TrieNode> knots) {
        if (knots.size() == 0) {
            return;
        }
        System.out.println(knots.get(0).isEmpty());
        TrieNode knot = knots.get(0);
        if (knot == null) {
            return;
        }

        if (knot.isWord()) {
            results.add(knot.getWord());
        }

        for (Character key : knot.getChildren().keySet()) {
            knots.add(knot.getChildren().get(key));
        }

        knots.remove(knot);

        getAllWords(results,knots);
    }


    public List<String> autoComplete(String prefix, int quantity) {

        return null;
    }

    public void remove(String word) {

    }
}
