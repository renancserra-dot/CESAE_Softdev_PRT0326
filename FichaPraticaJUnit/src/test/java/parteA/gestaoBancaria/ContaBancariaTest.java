package parteA.gestaoBancaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    ContaBancaria contaBancaria01;
    ContaBancaria contaBancaria02;
    ContaBancaria contaBancaria03;
    ContaBancaria contaBancaria04;
    ContaBancaria contaBancaria05;
    ContaBancaria contaBancaria06;

    @BeforeEach
    void setUp() {
        contaBancaria01 = new ContaBancaria("Joaquim", 1000, 2026, "PT", "PT50 123");
        contaBancaria02 = new ContaBancaria("Jorge", 4, 2024, "ES", "ES33 111");
        contaBancaria03 = new ContaBancaria("Joana", 0, 2010, "PT", "PT50 222");
        contaBancaria04 = new ContaBancaria("Roberto", 0, 1999, "PT", "PT50 333");
        contaBancaria05 = new ContaBancaria("Fernando", -50, 2022, "PT", "PT50 444");
        contaBancaria06 = new ContaBancaria("Fernanda", -150, 2021, "PT", "PT50 555");
    }


    @Test
    public void testConsultarSaldo() {
        assertEquals(1000, contaBancaria01.consultarSaldo());
        assertEquals(4, contaBancaria02.consultarSaldo());
        assertEquals(0, contaBancaria03.consultarSaldo());
        assertEquals(-150, contaBancaria06.consultarSaldo());
    }

    @Test
    public void testCalcularMargemEmprestimoPositivo() {
        assertEquals(500, contaBancaria01.calcularMargemEmprestimo());
        assertEquals(2, contaBancaria02.calcularMargemEmprestimo());
    }

    @Test
    public void testCalcularMargemEmprestimoZero() {
        assertEquals(0, contaBancaria03.calcularMargemEmprestimo());
        assertEquals(0, contaBancaria04.calcularMargemEmprestimo());

    }

    @Test
    public void testCalcularMargemEmprestimoNegativo() {
        assertEquals(0, contaBancaria05.calcularMargemEmprestimo());
        assertEquals(0, contaBancaria06.calcularMargemEmprestimo());
    }

    @Test
    public void testDepositarValorPositivo() {

        contaBancaria01.depositar(200);
        assertEquals(1200, contaBancaria01.consultarSaldo());

        contaBancaria03.depositar(25);
        assertEquals(25, contaBancaria03.consultarSaldo());
    }

    @Test
    public void testDepositarValorZero() {

        assertThrows(IllegalArgumentException.class, () -> contaBancaria01.depositar(0));

    }

    @Test
    public void testDepositarValorNegativo() {

        assertThrows(IllegalArgumentException.class, () -> contaBancaria01.depositar(-50));

    }
}