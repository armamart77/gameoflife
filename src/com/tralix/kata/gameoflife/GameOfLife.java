package com.tralix.kata.gameoflife;

public class GameOfLife {

    private static final char MUERTA = '-';

    private static final char VIVA = '*';

    char[][] celulas = new char[][] { { MUERTA, MUERTA, MUERTA }, { MUERTA, MUERTA, MUERTA },
            { MUERTA, MUERTA, MUERTA } };

    public char[][] procesa(final char[][] entrada) {
        for (int fila = 0; fila < entrada.length; fila++) {
            for (int columna = 0; columna < entrada[fila].length; columna++) {
                procesaCelula(entrada, fila, columna);
            }
        }
        return celulas;
    }

    private void procesaCelula(final char[][] entrada, final int fila, final int columna) {
        char celula = entrada[fila][columna];
        if (celula == VIVA) {
            verificaCambioDeEstadoParaViva(entrada, fila, columna);
        }
    }

    private void verificaCambioDeEstadoParaViva(final char[][] entrada, final int fila, final int columna) {
        int totalVivos = getVecinosVivos(fila, columna, entrada);
        if (totalVivos > 1) {
            celulas[fila][columna] = VIVA;
        }
    }

    private int getVecinosVivos(final int fila, final int columna, final char[][] entrada) {
        int totalVivos = 0;
        for (int filaTemp = fila - 1; filaTemp <= fila + 1; filaTemp++) {
            for (int columnaTemp = columna - 1; columnaTemp <= columna + 1; columnaTemp++) {
                if (!esLaMismaCelula(fila, columna, filaTemp, columnaTemp)) {
                    if (estaVivaCelula(entrada, filaTemp, columnaTemp)) {
                        totalVivos++;
                    }
                }
            }
        }
        return totalVivos;
    }

    private Boolean estaVivaCelula(final char[][] entrada, final int filaTemp, final int columnaTemp) {
        if (esPosicionValida(filaTemp, columnaTemp)) {
            if (entrada[filaTemp][columnaTemp] == VIVA) {
                return true;
            }
        }
        return false;
    }

    private boolean esLaMismaCelula(final int fila, final int columna, final int filaTemp, final int columnaTemp) {
        return filaTemp == fila && columnaTemp == columna;
    }

    private boolean esPosicionValida(final int filaTemp, final int columnaTemp) {
        return (filaTemp >= 0 && columnaTemp >= 0) && (filaTemp < 3 && columnaTemp < 3);
    }

    private void imprimirEntrada(final char[][] entrada) {
        for (int fila = 0; fila < entrada.length; fila++) {
            for (int columna = 0; columna < entrada[fila].length; columna++) {
                System.out.print(entrada[fila][columna]);
            }
            System.out.println("\n");
        }
    }

}
