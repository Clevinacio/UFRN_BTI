import br.ufrn.imd.edb2.Huffman;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class HuffmanTest {
//  Teste função contagem frequência
    @org.junit.Test
    public void characterFrequency() throws IOException {
        //Arrange
        String texto = "teste.txt";
        Huffman h = new Huffman();

        //Act
        HashMap<Character,Integer> result = h.characterFrequency(texto);

        //Assert
        assertTrue(result.containsKey('c'));
    }

    @org.junit.Test
    public void peekMustBetheBiggest() {
        //Arrange
    }

}