import br.ufrn.imd.edb2.MinHeap;
import br.ufrn.imd.edb2.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void addNode() {
//      Arrange
        Node n = new Node('c', 1);
        MinHeap m = new MinHeap();

//      Act
        m.addNode(n);

//      Assert
        assertTrue(m.getSize()==1);
    }

    @Test
    public void peek() {
//      Arrange
        Node n1 = new Node('c', 1);
        Node n2 = new Node('d', 2);
        MinHeap m = new MinHeap();
//      Act
        m.addNode(n1);
        m.addNode(n2);

//      Assert
        assertEquals(m.peek(),n1);
    }

    @Test
    public void remove() {
        //      Arrange
        Node n1 = new Node('c', 1);
        Node n2 = new Node('d', 2);
        MinHeap m = new MinHeap();
//      Act
        m.addNode(n1);
        m.addNode(n2);

        m.remove();

//      Assert
        assertEquals(m.peek(),n2);
    }
}