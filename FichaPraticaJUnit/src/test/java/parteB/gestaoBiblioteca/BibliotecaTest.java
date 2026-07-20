package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Livro livro1;
    Livro livro2;
    Livro livro3;
    Livro livro4;
    Livro livro5;

    Biblioteca biblioteca1;
    Biblioteca biblioteca2;


    @BeforeEach
    void setUp() {
        livro1 = new Livro("Fadas ;)", "Sara", 2026, 500);
        livro2 = new Livro("Aprender Java", "Joaquim", 2025, 790);
        livro3 = new Livro("Aprender C#", "Joaquim", 2025, 400);
        livro4 = new Livro("Aprender Javascript", "Joaquim", 2022, 55);
        livro5 = new Livro("Fadas 2", "Sara", 2026, 600);

        biblioteca1 = new Biblioteca();
        biblioteca2 = new Biblioteca();
    }

    @Test
    public void testContarLivros(){
        assertEquals(0, biblioteca1.contarLivros());
        assertEquals(0, biblioteca2.contarLivros());
    }

    @Test
    public void testAdicionarLivro() {

        biblioteca1.adicionarLivro(livro1);

        assertEquals(1, biblioteca1.contarLivros());

        biblioteca1.adicionarLivro(livro2);
        biblioteca1.adicionarLivro(livro3);

        assertEquals(3, biblioteca1.contarLivros());

    }

    @Test
    public void testPesquisarLivroPorTituloExistente(){

        biblioteca1.adicionarLivro(livro1);
        biblioteca1.adicionarLivro(livro2);
        biblioteca1.adicionarLivro(livro3);
        biblioteca1.adicionarLivro(livro4);
        biblioteca1.adicionarLivro(livro5);

        assertEquals(livro2, biblioteca1.pesquisarLivroPorTitulo("Aprender Java"));
        assertEquals(livro5, biblioteca1.pesquisarLivroPorTitulo("Fadas 2"));
    }

    @Test
    public void testPesquisarLivroPorTituloNaoExistente(){

        biblioteca1.adicionarLivro(livro1);
        biblioteca1.adicionarLivro(livro2);
        biblioteca1.adicionarLivro(livro3);
        biblioteca1.adicionarLivro(livro4);
        biblioteca1.adicionarLivro(livro5);

        assertNull(biblioteca1.pesquisarLivroPorTitulo("Os 3 patinhos"));
    }

}