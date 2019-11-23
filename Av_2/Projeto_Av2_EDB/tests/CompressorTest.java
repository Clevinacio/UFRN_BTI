import br.ufrn.imd.edb2.Compressor;
import br.ufrn.imd.edb2.MinHeap;
import br.ufrn.imd.edb2.Node;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class CompressorTest {
//  Teste função contagem frequência
    @Test
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

    @Test
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

    @Test
    public void nodeMustBeTheSmallest() throws IOException {
//      Arrange
        Compressor h = new Compressor();
        MinHeap result = new MinHeap();
        Node v1,v2;
//      Act
        h.characterFrequency("teste",0);
        result = h.makeMinHeap();
        v1 = result.remove();
        v2 = result.remove();

//      Assert
        assertTrue(v1.getCount()<=v2.getCount());
    }

    @Test
    public void sumMustEqualHeapCodeCountValue() throws IOException {
//      Arrange
        Compressor huff = new Compressor();
        HashMap<Character,Integer> result;

//      Act
        result = huff.characterFrequency("teste",0);
        huff.heapCode();

//      Assert
        assertTrue(huff.getHeapCode().getLeft().getCount()+huff.getHeapCode().getRight().getCount()==huff.getHeapCode().getCount());
    }

    @Test
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

    @Test
    public void MapCodeTableMustValueMustReturn1() {
//      Arrange
        Node heap = new Node('h',1);
        Compressor c = new Compressor();
        String letter;

//      Act
        c.setHeapCode(heap);
        c.makeCodificationTable();

//      Assert
        assertTrue(c.getMapCodeTable().get('h').equals("1"));
    }

    @Test
    public void MustHaveEdzFile() throws Exception {
//      Arrange
        Compressor c = new Compressor("teste1.txt");
        File file;

//      Act
        c.characterFrequency();
        c.heapCode();
        c.makeCodificationTable();
        c.CompressTextToFile("convert.edz","symbolTable.edt");

        file = new File("convert.edz");

//      Assert
//        assertTrue(file.exists());
    }

    @Test
    public void MustHaveEdtFile() throws Exception {
//      Arrange
        Compressor c = new Compressor("teste1.txt");
        File file;

//      Act
        c.characterFrequency();
        c.heapCode();
        c.makeCodificationTable();
        c.CompressTextToFile("convert.edz","symbolTable.edt");

        file = new File("symbolTable.edt");

//      Assert
        assertTrue(file.exists());
    }

    @Test
    public void ArrayMustHaveSameSizeOfBitSet() {
//      Arrange
        BitSet bs = new BitSet();
        Compressor c = new Compressor();
        byte[] bytes;
//      Act
        bs.set(7);
        bs.set(26);
        bytes = c.convertBitSetToArray(bs);

//      Assert
        assertTrue(bytes.length==4);

    }

}