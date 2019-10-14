import br.ufrn.imd.edb2.Compressor;
import br.ufrn.imd.edb2.MinHeap;
import br.ufrn.imd.edb2.Node;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class CompressorTest {
//  Teste função contagem frequência
    @org.junit.Test
    public void characterFrequency() throws IOException {
        //Arrange
        String texto = "teste";
        Compressor h = new Compressor();
        HashMap<Character,Integer> result;

        //Act
        result = h.characterFrequency(texto, 0);

        //Assert
        assertTrue(result.containsKey('e'));
    }

    @org.junit.Test
    public void peekMustBeTheBiggest() throws IOException {
        //Arrange
        Compressor h = new Compressor();
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
        Compressor h = new Compressor();
        MinHeap result = new MinHeap();
        Node v1,v2;
//      Act
        h.characterFrequency("teste1.txt");
        result = h.makeMinHeap();
        v1 = result.remove();
        v2 = result.remove();


//      Assert
        assertTrue(v1.getCount()<=v2.getCount());
    }

    @org.junit.Test
    public void sumMustEqualHeapCodeCountValue() throws IOException {
//      Arrange
        Compressor huff = new Compressor();
        HashMap<Character,Integer> result;

//      Act
        result = huff.characterFrequency("teste1.txt");
        huff.heapCode();

//      Assert
        assertTrue(huff.getHeapCode().getLeft().getCount()+huff.getHeapCode().getRight().getCount()==huff.getHeapCode().getCount());
    }

    @org.junit.Test
    public void codeMustReturn1() {
//      Arrange
        Node root = new Node('c', 1);
        Node left = new Node('d', 2);
        Node right = new Node('a', 3);
        Compressor c = new Compressor();
        String letter;

//      Act
        root.setLeft(left);
        root.setRight(right);
        c.setCode(root, "");
        letter = c.getMapCodeTable().get('a');

//      Arrange
        assertEquals(letter, "1");
    }

}