package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

public class LibroEnBiblioteca {
    private final Libro libro;
    private int cantidadDeCopias;

    public LibroEnBiblioteca(Libro libro, int cantidadDeCopias) {
        this.libro = libro;
        this.cantidadDeCopias = cantidadDeCopias;
    }

    public LibroEnBiblioteca(Libro libro) {
        this(libro, 0);
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCantidadDeCopias() {
        return cantidadDeCopias;
    }
}
