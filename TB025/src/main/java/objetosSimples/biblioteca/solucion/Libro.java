package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record Libro(String isbn, String titulo, LocalDate fechaDePublicacion, List<String> autores) {
    public Libro {
        Validaciones.validarNotNull(isbn, "ISBN");
        Validaciones.validarNoVacio(isbn, "ISBN");
        Validaciones.validarNotNull(titulo, "título");
        Validaciones.validarNoVacio(titulo, "título");
        Validaciones.validarNotNull(fechaDePublicacion, "Fecha de publicación");
        Validaciones.validarNotNull(autores, "Autores");

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}
