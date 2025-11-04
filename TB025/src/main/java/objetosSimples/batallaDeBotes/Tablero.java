package main.java.objetosSimples.batallaDeBotes;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.Random;

public class Tablero<T> {

    private Casillero<T>[][] casilleros;

    public Tablero(int base, int altura) {
        Validaciones.validarMayorACero(base, "base");
        Validaciones.validarMayorACero(altura, "altura");
        this.inicializarCasilleros(base, altura);
    }

    public Casillero<T> getCasillero(int coordX, int coordY) {
        this.validarCoordenadas(coordX, coordY);
        return this.casilleros[coordX][coordY];
    }

    public void reiniciar() {
        this.inicializarCasilleros(this.casilleros.length, this.casilleros[0].length);
    }

    public boolean sonCoordenadasValidas(int coordX, int coordY) {
        return (0 <= coordX && coordX < this.casilleros.length) &&
                (0 <= coordY && coordY < this.casilleros[0].length);
    }

    public Casillero<T> obtenerCasilleroAleatorio(Random random) {
        int coordX = random.nextInt(this.casilleros.length + 1);
        int coordY = random.nextInt(this.casilleros[0].length + 1);
        return this.getCasillero(coordX, coordY);
    }

    private void inicializarCasilleros(int base, int altura) {
        this.casilleros = new Casillero[base][altura];
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < altura; j++) {
                this.casilleros[i][j] = new Casillero<>();
            }
        }
    }

    private void validarCoordenadas(int coordX, int coordY) {
        if (!sonCoordenadasValidas(coordX, coordY)) {
            throw new RuntimeException("Coordenadas inválidas");
        }
    }




}
