package main.java.objetosSimples.batallaDeBotesV2;

/*
* class Juego {
-tablero: Tablero<Bote>
+agregarBote(bote, x, y): void
+estaOcupado(x, y): boolean
+disparar(x, y, tipoDisparo): boolean // Devuelve si el disparo fue exitoso y si el bote se hundió
+reiniciar(): void
+ubicarBotes(...botes): void
}
* */

public class Juego {

    private final static int TAMANIO_TABLERO = 8;

    private final Tablero<Bote> tablero;

    public Juego() {
        this.tablero = new Tablero<>(TAMANIO_TABLERO,TAMANIO_TABLERO);
    }

    public void agregarBote(Bote bote, int x, int y) {
        Casillero<Bote> casillero = this.tablero.getCasillero(x, y);
        casillero.ocupar(bote);
    }

    public boolean estaOcupado(int x, int y) {
        return false;
    }

    public boolean disparar(int x, int y, TipoDeDisparo tipoDeDisparo) {
        return false;
    }

    public void reiniciar() {

    }

    public void ubicarBotesAletoriamente(Bote ...botes) {

    }
}
