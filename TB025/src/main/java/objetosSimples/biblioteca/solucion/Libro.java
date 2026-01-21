package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Representa la definición inmutable de un libro.
 * La identidad del libro está determinada exclusivamente por su ISBN.
 */
public record Libro(String isbn, String titulo, LocalDate fechaDePublicacion, List<Autor> autores) {

    /**
     * Constructor compacto. Realiza validaciones y copias defensivas.
     */
    public Libro {
        Validaciones.validarNotNull(isbn, "ISBN");
        Validaciones.validarNoVacio(isbn, "ISBN");
        Validaciones.validarNotNull(titulo, "título");
        Validaciones.validarNoVacio(titulo, "título");
        Validaciones.validarNotNull(fechaDePublicacion, "Fecha de publicación");
        Validaciones.validarNotNull(autores, "Autores");
        if (autores.isEmpty()) {
            throw new IllegalArgumentException("Un libro debe tener al menos un autor.");
        }
        autores = List.copyOf(autores);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                '}';
    }
}
