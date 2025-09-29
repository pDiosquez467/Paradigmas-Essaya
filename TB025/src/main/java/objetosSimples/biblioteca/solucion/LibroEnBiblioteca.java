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

    public String isbn() {
        return libro.isbn();
    }

    public void agregarCopias(int cantidadDeCopiasNuevas) {
        Validaciones.validarMayorACero(cantidadDeCopiasNuevas, "'cantidadDeCopias' debe ser mayor a cero");
        cantidadDeCopias += cantidadDeCopiasNuevas;
    }

    public void gestionarPrestamo() {
        if (cantidadDeCopias == 0) {
            throw new RuntimeException("No hay copias disponibles");
        }
        cantidadDeCopias -= 1;
    }
}
