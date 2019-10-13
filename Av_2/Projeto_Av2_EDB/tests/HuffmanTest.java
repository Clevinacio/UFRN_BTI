import br.ufrn.imd.edb2.Huffman;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class HuffmanTest {
//  Teste função contagem frequência
    @org.junit.Test
    public void characterFrequency() throws IOException {
        //Arrange
        String texto = "teste1.txt";
        Huffman h = new Huffman();
        HashMap<Character,Integer> result;

                //Act
        result = h.characterFrequency(texto);

        //Assert|
        assertTrue(result.containsKey('c'));
    }

    @org.junit.Test
    public void peekMustBeTheBiggest() throws IOException {
        //Arrange
        Huffman h = new Huffman();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Map.Entry<Character, Integer>> unordered;
        List<Map.Entry<Character, Integer>> ordered;
        //Act
        map.put('a',10);
        map.put('b',20);
        map.put('c',30);
        map.put('d',140);
        map.put('e',50);
        unordered = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        map = h.sort(map);
        ordered = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        //Assert
        assertTrue(ordered!=unordered);

    }

    @org.junit.Test
    public void nodeMustBeTheSmallest() {

    }

    @org.junit.Test
    public void heapCode() throws IOException {
//      Arrange
        Huffman huff = new Huffman();
        HashMap<Character,Integer> result;

//      Act
        result = huff.characterFrequency("abreu", 0);
        huff.heapCode();
        System.out.println(huff.getHeapCode().getLetter());
//      Assert

    }

}