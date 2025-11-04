package main.java.objetosSimples.batallaDeBotes;

import java.util.Random;

public class Juego {
    private final static int TAMANIO_TABLERO = 8;
    private final static int CANTIDAD_BOTES = 8;

    private final Tablero<Bote> tablero;

    public Juego() {
        this.tablero = new Tablero<>(TAMANIO_TABLERO, TAMANIO_TABLERO);
    }

    public void agregarBotes(Bote ...botes) {
        if (botes.length != CANTIDAD_BOTES) {
            throw new RuntimeException("Se deben proporcionar exactamente " + CANTIDAD_BOTES + " botes.");
        }
        Random random = new Random();
        for (int i = 0; i < CANTIDAD_BOTES; i++) {
            Bote bote = botes[i];
            boolean colocado = false;
            while (!colocado) {
                Casillero<Bote> casillero =
                        this.tablero.obtenerCasilleroAleatorio(random); // Asumiendo que ahora acepta Random
                if (casillero.estaVacio()) {
                    casillero.ocupar(bote);
                    colocado = true;
                }
            }
        }
    }

    public boolean casilleroOcupado(int coordX, int coordY) {
        Casillero<Bote> casillero = this.tablero.getCasillero(coordX, coordY);
        if (casillero.estaVacio()) return false;
        Bote bote = casillero.getValor();
        return !bote.estaHundido();
    }

    public Bote getBote(int coordX, int coordY) {
        return (this.casilleroOcupado(coordX, coordY)) ?
                this.tablero.getCasillero(coordX, coordY).getValor() : null;
    }

    public boolean disparar(Bote atacante, int coordX, int coordY) {
        if (this.casilleroOcupado(coordX, coordY)) {
            Bote objetivo = this.getBote(coordX, coordY);
            objetivo.recibirDanio(atacante.ataque());
            return true;
        }
        return false;
    }

    public void reiniciarJuego() {
        this.tablero.reiniciar();
    }
}
