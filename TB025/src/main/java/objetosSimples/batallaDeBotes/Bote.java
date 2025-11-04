package main.java.objetosSimples.batallaDeBotes;

import main.java.objetosSimples.validaciones.Validaciones;

public class Bote {

    private int vida;
    private final int ataque;

    public Bote(int vida, int ataque) {
        Validaciones.validarMayorACero(vida, "vida");
        Validaciones.validarMayorACero(ataque, "ataque");
        this.vida = vida;
        this.ataque = ataque;
    }

    public void recibirDanio(int danio) {
        this.vida = Math.max(0, this.vida - danio);
    }

    public boolean estaHundido() {
        return this.vida == 0;
    }

    public int getAtaque() {
        return ataque;
    }
}
