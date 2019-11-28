package br.ufrn.imd.bti.edb2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void mustHaveToInsertWord() {
//      Arrange
        Trie t = new Trie();
        String word = "bola";

//      Act
        t.insert(word);

//      Assert
        assertTrue(!t.getRoot().isEmpty());
    }

    @Test
    public void mustFindWord() {
//      Arrange
        Trie t = new Trie();
        String word = "bola";

//      Act
        t.insert(word);

//      Assert
        assertTrue(t.search(word));
    }

    @Test
    public void mustBePopulated() {
//      Arrange
        Trie t = new Trie();
        String word1 = "bola";
        String word2 = "balão";
        String word3 = "bala";
        List<String> results = new ArrayList<>();
//      Act
        t.insert(word1);
        t.insert(word2);
        t.insert(word3);

        results = t.autoComplete("b");

//      Assert
        assertTrue(results.size() == 3);
    }

    @Test
    public void mustHaveTheRightAmount() {
//      Arrange
        Trie t = new Trie();
        String word1 = "bola";
        String word2 = "balão";
        String word3 = "bala";
        List<String> results = new ArrayList<>();
//      Act
        t.insert(word1);
        t.insert(word2);
        t.insert(word3);

        results = t.autoComplete("b",2);

//      Assert
        assertTrue(results.size() == 2);
    }
}