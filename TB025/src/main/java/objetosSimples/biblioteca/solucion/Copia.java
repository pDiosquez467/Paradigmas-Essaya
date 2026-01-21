package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;
import java.util.Objects;

/**
 * Representa un ejemplar físico de un libro en la biblioteca.
 * Posee un estado mutable que gestiona su disponibilidad.
 */
public class Copia {
    private final String id;
    private final Libro libro;
    private EstadoDeCopia estado;

    public Copia(String id, Libro libro) {
        Validaciones.validarNotNull(id, "id");
        Validaciones.validarNoVacio(id, "id");
        Validaciones.validarNotNull(libro, "libro");

        this.id = id;
        this.libro = libro;
        this.estado = EstadoDeCopia.DISPONIBLE;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Copia copia)) return false;
        return Objects.equals(id, copia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public EstadoDeCopia getEstado() {
        return estado;
    }

    /**
     * Marca la copia como prestada.
     * @throws IllegalStateException si la copia no está disponible para préstamo.
     */
    public void prestar() {
        if (this.estado != EstadoDeCopia.DISPONIBLE) {
            throw new IllegalStateException("La copia no está disponible. Estado actual: " + this.estado);
        }
        this.estado = EstadoDeCopia.PRESTADO;
    }

    /**
     * Registra la devolución de una copia, dejándola disponible nuevamente.
     * @throws IllegalStateException si la copia no estaba prestada.
     */
    public void devolver() {
        if (this.estado != EstadoDeCopia.PRESTADO) {
            throw new IllegalStateException("No se puede devolver una copia que no está prestada. Estado actual: " + this.estado);
        }
        this.estado = EstadoDeCopia.DISPONIBLE;
    }

    /**
     * Registra el reingreso de una copia, dejándola disponible nuevamente.
     * @throws IllegalStateException si la copia no estaba perdida o en reparación.
     */
    public void reingresar() {
        if (this.estado != EstadoDeCopia.EN_REPARACION &&
                this.estado != EstadoDeCopia.PERDIDO) {
            throw new IllegalStateException("No se puede reingresar una copia disponible o prestada. Estado actual: " + this.estado);
        }
        this.estado = EstadoDeCopia.DISPONIBLE;
    }

    /**
     * Indica si la copia pertenece al libro cuyo ISBN es dado.
     * @param isbn: el ISBN del libro a verificar.
     * @return verdadero si la copia es del libro cuyo ISBN es dado.
     */
    public boolean esDe(String isbn) {
        return Objects.equals(isbn, libro.isbn());
    }

    @Override
    public String toString() {
        return "Copia{" +
                "id='" + id + '\'' +
                ", libro=" + libro +
                ", estado=" + estado +
                '}';
    }
}