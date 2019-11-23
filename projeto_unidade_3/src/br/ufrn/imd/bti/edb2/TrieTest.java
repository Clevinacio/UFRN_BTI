package br.ufrn.imd.bti.edb2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void mustHaveSameLenght() {
//      Arrange
        Trie t = new Trie();
        String word = "bola";
//      Act
        t.insert(word);

//      Assert
        assertTrue( word.length() == t.getRoot().getChildren().size());
    }

}