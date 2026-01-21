package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa a un autor de obras literarias dentro del sistema de biblioteca.
 * Esta clase es inmutable.
 */
public class Autor {
    private final String nombre; // 'final' refuerza la inmutabilidad
    private final LocalDate fechaDeNacimiento;
    private final String nacionalidad;

    /**
     * Construye un nuevo Autor.
     *
     * @param nombre El nombre completo del autor. No puede ser nulo ni vacío.
     * @param fechaDeNacimiento La fecha de nacimiento. No puede ser nula.
     * @param nacionalidad La nacionalidad del autor. No puede ser nula.
     * @throws RuntimeException si algún argumento no es válido.
     */
    public Autor(String nombre, LocalDate fechaDeNacimiento, String nacionalidad) {
        Validaciones.validarNotNull(nombre, "nombre");
        Validaciones.validarNoVacio(nombre, "nombre");
        Validaciones.validarNotNull(fechaDeNacimiento, "fechaDeNacimiento");
        Validaciones.validarNotNull(nacionalidad, "nacionalidad");

        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nombre, autor.nombre) &&
                Objects.equals(fechaDeNacimiento, autor.fechaDeNacimiento) &&
                Objects.equals(nacionalidad, autor.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaDeNacimiento, nacionalidad);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}