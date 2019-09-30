package br.ufrn.imd.lpii;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaBancoTest {

    FilaBanco fila = null;

    @Before
    public void init() {
        fila = new FilaBanco();
    }

    @Test
    public void mustBeOrdered() {
        //Arrange
        Pessoa pessoa1 = new Pessoa("Teste", 20);
        Pessoa pessoa2 = new Pessoa("Teste", 30);
        Pessoa pessoa3 = new Pessoa("Teste", 60);

        //Act
        fila.addPessoa(pessoa1);
        fila.addPessoa(pessoa2);
        fila.addPessoa(pessoa3);

        //Assert
        assertSame(pessoa3, fila.peek());
        fila.remove();

        assertSame(pessoa2, fila.peek());
        fila.remove();

        assertSame(pessoa1, fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void mustBeInitializedEmpty() {
        //Assert
        assertNull(fila.peek());
    }

    @Test
    public void peekMustReturnAddedElement() {
        //Arrange
        Pessoa node = new Pessoa("Fulano",10);

        //Act
        fila.addPessoa(node);

        //Assert
        assertSame(node,fila.peek());
    }

    @Test
    public void mustReoderWhenPriorityChange() {
        //Arrange
        Pessoa pessoa1 = new Pessoa("Teste1", 20);
        Pessoa pessoa2 = new Pessoa("Teste2", 30);
        Pessoa pessoa3 = new Pessoa("Teste3", 60);
        fila.addPessoa(pessoa1);
        fila.addPessoa(pessoa2);
        fila.addPessoa(pessoa3);

        //Act
        pessoa2.setIdade(80);

        //Assert
        assertSame(pessoa2, fila.peek());
    }
}