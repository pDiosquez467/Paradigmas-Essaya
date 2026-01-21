package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.*;

/**
 * Representa el inventario de la biblioteca.
 * Es el responsable de mantener la integridad referencial entre los libros (metadata)
 * y las copias físicas (stock).
 */
public class Catalogo {
    private final Map<String, Libro> libros;
    private final Map<String, List<Copia>> copias;

    public Catalogo() {
        this.libros = new HashMap<>();
        this.copias = new HashMap<>();
    }

    /**
     * Agrega un nuevo libro al catálogo (solo la definición/metadata).
     * @param libro El libro a agregar.
     * @throws IllegalStateException si ya existe un libro con ese ISBN.
     */
    public void agregarLibro(Libro libro) {
        Validaciones.validarNotNull(libro, "libro");
        if (this.libros.containsKey(libro.isbn())) {
            throw new IllegalStateException("El libro con ISBN " + libro.isbn() + " ya existe en el catálogo.");
        }
        this.libros.put(libro.isbn(), libro);
    }

    /**
     * Remueve un libro del catálogo.
     * @param isbn El ISBN del libro a remover.
     * @return El libro removido.
     * @throws IllegalStateException si el libro tiene copias físicas asociadas (stock > 0).
     */
    public Libro removerLibro(String isbn) {
        Validaciones.validarNotNull(isbn, "isbn");
        if (!this.libros.containsKey(isbn)) {
            throw new IllegalStateException("El libro no pertenece al catálogo.");
        }
        List<Copia> stock = this.copias.getOrDefault(isbn, Collections.emptyList());
        if (!stock.isEmpty()) {
            throw new IllegalStateException("No se puede eliminar el libro porque existen " + stock.size() + " copias asociadas.");
        }
        this.copias.remove(isbn);
        return this.libros.remove(isbn);
    }

    /**
     * Agrega una copia física al inventario.
     * @param copia La copia a agregar.
     * @throws IllegalStateException si el libro correspondiente no está dado de alta en el catálogo.
     */
    public void agregarCopia(Copia copia) {
        Validaciones.validarNotNull(copia, "copia");
        String isbn = copia.getLibro().isbn();
        if (!this.libros.containsKey(isbn)) {
            throw new IllegalStateException("No se puede agregar copia. El libro (ISBN: " + isbn + ") no existe en el catálogo.");
        }
        this.copias.computeIfAbsent(isbn, k -> new ArrayList<>()).add(copia);
    }

    /**
     * Busca un libro por su ISBN.
     * @param isbn Identificador del libro.
     * @return Un Optional con el libro si existe, o empty si no.
     */
    public Optional<Libro> buscarLibro(String isbn) {
        Validaciones.validarNotNull(isbn, "isbn");
        return Optional.ofNullable(this.libros.get(isbn));
    }

    /**
     * Busca la primera copia disponible para préstamo de un título dado.
     * @param isbn El ISBN del libro.
     * @return Un Optional con la copia disponible, o empty si no hay stock.
     */
    public Optional<Copia> buscarCopiaDisponible(String isbn) {
        Validaciones.validarNotNull(isbn, "isbn");
        List<Copia> stock = this.copias.getOrDefault(isbn, Collections.emptyList());
        return stock.stream()
                .filter(c -> c.getEstado() == EstadoDeCopia.DISPONIBLE)
                .findFirst();
    }

    /**
     * Consulta la cantidad de copias DISPONIBLES (no prestadas ni en reparación).
     * @param isbn El ISBN del libro.
     * @return La cantidad de copias disponibles.
     */
    public int consultarStock(String isbn) {
        Validaciones.validarNotNull(isbn, "isbn");
        List<Copia> stock = this.copias.getOrDefault(isbn, Collections.emptyList());
        return (int) stock.stream()
                .filter(c -> c.getEstado() == EstadoDeCopia.DISPONIBLE)
                .count();
    }

    /**
     * Busca una copia específica por su ID.
     * Útil para inventario o reparaciones.
     */
    public Optional<Copia> buscarCopia(String idCopia) {
        Validaciones.validarNotNull(idCopia, "idCopia");
        return this.copias.values().stream()
                .flatMap(List::stream)
                .filter(c -> c.getId().equals(idCopia))
                .findFirst();
    }
}