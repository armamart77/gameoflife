package com.tralix.kata.gameoflife.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.tralix.kata.gameoflife.GameOfLife;

public class GameOfLifeTest {

    private GameOfLife gameOfLife;

    @Before
    public void setup() {
        gameOfLife = new GameOfLife();
    }

    @Test
    public void todosMuertosGeneraPurosMuertos() throws Exception {
        char[][] entrada = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] esperado = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] salida = gameOfLife.procesa(entrada);
        assertArrayEquals(esperado, salida);
    }

    @Test
    public void soloUnaCelulaViva() {
        char[][] entrada = new char[][] { { '*', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] esperado = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] salida = gameOfLife.procesa(entrada);
        assertArrayEquals(esperado, salida);
    }

    @Test
    public void dosCelulasVivas() {
        char[][] entrada = new char[][] { { '*', '*', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] esperado = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] salida = gameOfLife.procesa(entrada);
        assertArrayEquals(esperado, salida);
    }

    @Test
    public void treCelulasVivas() {
        char[][] entrada = new char[][] { { '*', '*', '*' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] esperado = new char[][] { { '-', '*', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        char[][] salida = gameOfLife.procesa(entrada);
        assertArrayEquals(esperado, salida);
    }

    @Test
    public void treCelulasVivasEnTriangulo() {
        char[][] entrada = new char[][] { { '*', '*', '-' }, { '*', '-', '-' }, { '-', '-', '-' } };
        char[][] esperado = new char[][] { { '*', '*', '-' }, { '*', '-', '-' }, { '-', '-', '-' } };
        char[][] salida = gameOfLife.procesa(entrada);
        assertArrayEquals(esperado, salida);
    }

}
