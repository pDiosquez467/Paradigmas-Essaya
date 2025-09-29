package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.HashMap;

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








}
