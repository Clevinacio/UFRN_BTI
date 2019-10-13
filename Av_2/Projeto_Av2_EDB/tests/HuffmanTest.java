import br.ufrn.imd.edb2.Huffman;
import br.ufrn.imd.edb2.MinHeap;

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
    public void nodeMustBeTheSmallest() throws IOException {
//      Arrange
        Huffman h = new Huffman();
        MinHeap result = new MinHeap();

//      Act
        h.characterFrequency("teste",0);
        result = h.makeMinHeap();

//      Assert
        assertTrue(result.peek().getCount()==1);
    }

    @org.junit.Test
    public void heapCode() throws IOException {
//      Arrange
        Huffman huff = new Huffman();
        HashMap<Character,Integer> result;

//      Act
        result = huff.characterFrequency("teste1.txt");
        huff.heapCode();

//      Assert
        assertTrue(huff.getHeapCode().getCount()==13);
    }

}