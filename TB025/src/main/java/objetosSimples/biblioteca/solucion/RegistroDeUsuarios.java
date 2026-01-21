package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistroDeUsuarios {
    private final Map<String, Usuario> usuarios;

    public RegistroDeUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        Validaciones.validarNotNull(usuario, "usuario");
        if (this.usuarios.containsKey(usuario.id())) {
            throw new IllegalStateException("El usuario ya existe en la biblioteca");
        }
        this.usuarios.put(usuario.id(), usuario);
    }

    public Optional<Usuario> buscarUsuario(String id) {
        Validaciones.validarNotNull(id, "id");
        return Optional.ofNullable(this.usuarios.get(id));
    }
}
