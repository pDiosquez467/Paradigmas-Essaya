package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.time.LocalDate;
import java.util.List;

public record Libro(String isbn, String titulo, LocalDate fechaDePublicacion, List<String> autores) {
    public Libro {
        Validaciones.validarNotNull(isbn, "ISBN");
        Validaciones.validarNoVacio(isbn, "ISBN");
        Validaciones.validarNotNull(titulo, "título");
        Validaciones.validarNoVacio(titulo, "título");
        Validaciones.validarNotNull(fechaDePublicacion, "Fecha de publicación");
        Validaciones.validarNotNull(autores, "Autores");

    }
}
