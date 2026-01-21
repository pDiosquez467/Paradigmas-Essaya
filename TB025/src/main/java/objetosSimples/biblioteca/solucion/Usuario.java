package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.Objects;

/**
 * Representa un usuario dentro del sistema de la biblioteca.
 * @param id: el identificador único del usuario dentro del sistema. No debe ser nulo ni vacío.
 * @param nombre: el nombre completo del usuario. No debe ser nulo ni vacío.
 */
public record Usuario(String id, String nombre) {
    public Usuario {
        Validaciones.validarNotNull(id, "id");
        Validaciones.validarNoVacio(id, "id");
        Validaciones.validarNotNull(nombre, "nombre");
        Validaciones.validarNoVacio(nombre, "nombre");

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
