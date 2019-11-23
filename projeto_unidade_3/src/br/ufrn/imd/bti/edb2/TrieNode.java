package br.ufrn.imd.bti.edb2;

import java.util.HashMap;

public class TrieNode {
    boolean isWord;
    private HashMap<Character, TrieNode> children;
    private String word;

    public String getWord() {
        return word;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public TrieNode() {
        this.isWord = false;
        this.word = "";
        this.children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(String word) {
        this.isWord = true;
        this.children = new HashMap<Character, TrieNode>();
        this.word = word;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean value) {
        isWord = value;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isEmpty() {
        return this.children.isEmpty();
    }
}
