package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Biblioteca {

    private final String nombre;
    private final HashMap<String, LibroEnBiblioteca> libros;
    private final HashMap<String, Usuario> usuarios;

    public Biblioteca(String nombre) {
        Validaciones.validarNotNull(nombre, "nombre");
        this.nombre = nombre;
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    // === LIBROS (ALTA/BAJA) ===

    public void agregarLibro(LibroEnBiblioteca libroEnBiblioteca) {
        Validaciones.validarNotNull(libroEnBiblioteca, "Libro");
        if (contieneLibro(libroEnBiblioteca)) {
            LibroEnBiblioteca almacenado = libros.get(libroEnBiblioteca.isbn());
            almacenado.agregarCopias(libroEnBiblioteca.getCantidadDeCopias());
            return;
        }
        libros.put(libroEnBiblioteca.isbn(), libroEnBiblioteca);
    }

    public void quitarLibro(LibroEnBiblioteca libroEnBiblioteca) {
        if (!contieneLibro(libroEnBiblioteca)) {
            throw new RuntimeException("El libro no pertenece a la biblioteca");
        }
        libros.remove(libroEnBiblioteca.isbn());
    }

    public boolean contieneLibro(LibroEnBiblioteca libroEnBiblioteca) {
        Validaciones.validarNotNull(libroEnBiblioteca, "Libro");
        return libros.containsKey(libroEnBiblioteca.isbn());
    }

    // === USUARIOS (ALTA/BAJA) ===

    public void agregarUsuario(Usuario usuario) {
        Validaciones.validarNotNull(usuario, "Usuario");
        if (contieneUsuario(usuario)) {
            throw new RuntimeException("El usuario ya pertenece a la biblioteca");
        }
        usuarios.put(usuario.getId(), usuario);
    }

    public void quitarUsuario(Usuario usuario) {
        if (!contieneUsuario(usuario)) {
            throw new RuntimeException("El usuario no pertenece a la biblioteca");
        }
        libros.remove(usuario.getId());
    }

    public boolean contieneUsuario(Usuario usuario) {
        Validaciones.validarNotNull(usuario, "Usuario");
        return usuarios.containsKey(usuario.getId());
    }

    // === PRÉSTAMOS ===

    public void prestarLibro(LibroEnBiblioteca libroEnBiblioteca, Usuario usuario) {
        // IDEA: Podríamos tener una clase 'Préstamo' que gestione préstamos y devoluciones, fechas y demás.

        if (!contieneLibro(libroEnBiblioteca)) {
            throw new RuntimeException();
        }

        if (!contieneUsuario(usuario)) {
            throw new RuntimeException();
        }

        libroEnBiblioteca.gestionarPrestamo();
        usuario.agregarLibro(libroEnBiblioteca.getLibro());
    }

    public void devolverLibro(LibroEnBiblioteca libroEnBiblioteca, Usuario usuario) {

    }

    // === CONSULTAS ===

    public List<Libro> librosPrestados(Usuario usuario) {
        Validaciones.validarNotNull(usuario, "Usuario");
        if (!contieneUsuario(usuario)) {
            throw new RuntimeException("El usuario no pertenece a la biblioteca");
        }
        return usuario.getLibrosPrestados();
    }

    public int consultarStock(LibroEnBiblioteca libroEnBiblioteca) {
        Validaciones.validarNotNull(libroEnBiblioteca, "Libro");
        if (!contieneLibro(libroEnBiblioteca)) {
            throw new RuntimeException("El libro no pertenece a la biblioteca");
        }
        return libros.get(libroEnBiblioteca.isbn()).getCantidadDeCopias();
    }

    public int consultarStockPorTitulo(String titulo) {
        Validaciones.validarNotNull(titulo, "Libro");
        return consultarStock(libroEnBiblioteca -> libroEnBiblioteca.getLibro().titulo().equals(titulo));
    }

    public int consultarStockPorAutor(String autor) {
        Validaciones.validarNotNull(autor, "Libro");
        return consultarStock(libroEnBiblioteca -> libroEnBiblioteca.getLibro().autores().contains(autor));
    }

    private int consultarStock(Predicate<LibroEnBiblioteca> criterio) {
        return libros.values().stream()
                .filter(criterio)
                .mapToInt(LibroEnBiblioteca::getCantidadDeCopias)
                .sum();
    }
}