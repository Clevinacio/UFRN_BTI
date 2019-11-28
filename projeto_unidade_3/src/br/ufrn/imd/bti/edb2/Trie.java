package br.ufrn.imd.bti.edb2;

import java.util.ArrayList;
import java.util.Collections;
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
        if (root == null) {
            this.root = new TrieNode("");
        }

        if (word.isEmpty()) {
            return;
        }

        int c = 0;
        TrieNode temp = root;
        TrieNode next = null;
        while (c <= word.length()-1) {
            if (temp.getChildren().get((Character) word.charAt(c)) == null) {
                if (c == word.length() - 1) {
                    TrieNode knot = new TrieNode(word);
                    temp.getChildren().put((Character) word.charAt(c), knot);
                    return;
                }
                TrieNode knot = new TrieNode();
                temp.getChildren().put((Character) word.charAt(c), knot);
                temp = knot;
                c++;
            } else {
                if (c == word.length() - 1) {
                    temp.getChildren().get((Character) word.charAt(c)).setIsWord();
                    temp.getChildren().get((Character) word.charAt(c)).setWord(word);
                    return;
                }
                next = temp.getChildren().get((Character) word.charAt(c));
                temp = next;
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
        List<String> results = new ArrayList<>();
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

        getAllWords(results, knots);
        WordLengthComparator wc = new WordLengthComparator();
        Collections.sort(results, wc);

        return results;
    }

    public List<String> autoComplete(String prefix, int quantity) {
        List<String> limitedResults = new ArrayList<>();
        List<String> results = autoComplete(prefix);
        int c = 0;

        if (results == null) {
            return null;
        }
        for (String word : results) {
            if (c < quantity) {
                limitedResults.add(word);
                c++;
            }
        }

        return limitedResults;
    }

    private void getAllWords(List<String> results, List<TrieNode> knots) {
        if (knots.size() == 0) {
            return;
        }

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
}
