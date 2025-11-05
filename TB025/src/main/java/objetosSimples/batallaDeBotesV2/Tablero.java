package main.java.objetosSimples.batallaDeBotesV2;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.Random;

public class Tablero<T> {

    private Casillero<T>[][] casilleros;

    // API PÚBLICA ---------------------------------------------------------------------

    public Tablero(int largo, int ancho) {
        Validaciones.validarMayorACero(largo, "largo");
        Validaciones.validarMayorACero(ancho, "ancho");
        this.inicializarCasilleros(largo, ancho);
    }

    public Casillero<T> getCasillero(int x, int y) {
        this.validarCoordenadas(x, y);
        return this.casilleros[x-1][y-1];
    }

    public boolean estaVacio(int x, int y) {
        this.validarCoordenadas(x, y);
        return this.getCasillero(x, y).estaVacio();

    }

    public boolean sonCoordenadasValidas(int x, int y) {
        return (0 <= x && x < this.casilleros.length) &&
                (0 <= y && y < this.casilleros[0].length);
    }

    public void reiniciarTablero() {
        this.inicializarCasilleros(this.casilleros.length, this.casilleros[0].length);
    }

    public Casillero<T> obtenerCasilleroAleatorio(Random random) {
        int randomX = random.nextInt(this.casilleros.length + 1);
        int randomY = random.nextInt(this.casilleros[0].length + 1);
        return this.casilleros[randomX][randomY];
    }

    // MÉTODOS PRIVADOS ---------------------------------------------------------------------

    private void inicializarCasilleros(int largo, int ancho) {
        this.casilleros = new Casillero[largo][ancho];
        for (int i = 0; i < this.casilleros.length; i++) {
            for (int j = 0; j < this.casilleros[0].length; j++) {
                this.casilleros[i][j] = new Casillero<T>();
            }
        }
    }

    private void validarCoordenadas(int x, int y) {
        if (!this.sonCoordenadasValidas(x, y)) {
            throw new RuntimeException("Coordenadas inválidas");
        }
    }
}
