package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private final String id;
    private final String nombre;
    private final List<Libro> librosPrestados;

    public Usuario(String id, String nombre) {
        // TODO: Agregar validaciones correspondientes.
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        Validaciones.validarNotNull(libro, "Libro");
        if (contieneLibro(libro)) {
            throw new RuntimeException("Libro repetido");
        }
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        Validaciones.validarNotNull(libro, "Libro");
        if (!contieneLibro(libro)) {
            throw new RuntimeException("Libro no encontrado");
        }
        librosPrestados.remove(libro);
    }

    public boolean contieneLibro(Libro libro) {
        return librosPrestados.stream()
                .anyMatch(l -> l.equals(libro));
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Libro> getLibrosPrestados() {
        return Collections.unmodifiableList(librosPrestados);
    }
}
