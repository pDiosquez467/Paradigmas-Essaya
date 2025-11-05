package main.java.objetosSimples.batallaDeBotesV2;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.Objects;

public abstract class Bote {

    private final String nombre;
    private final int vidaMaxima;
    private int vidaActual;

    public Bote(String nombre, int vidaMaxima) {
        Validaciones.validarNotNull(nombre, "nombre");
        Validaciones.validarNoVacio(nombre, "nombre");
        Validaciones.validarMayorACero(vidaMaxima, "vidaMaxima");
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
    }

    public boolean estaHundido() {
        return this.vidaActual == 0;
    }

    public abstract void recibirDisparo(TipoDeDisparo tipoDeDisparo);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bote bote)) return false;
        return Objects.equals(nombre, bote.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Bote{" +
                "nombre='" + nombre + '\'' +
                ", vidaMaxima=" + vidaMaxima +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    protected void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
}
