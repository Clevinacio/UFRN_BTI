import br.ufrn.imd.edb2.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {


    @Test
    public void isLeaf() {
//      Arrange
        Node n = new Node('c', 1);

//      Act
        n.setLeft(null);
        n.setRight(null);

//      Assert
        assertTrue(n.isLeaf());
    }
}