package main.java.ObjetosSimples.Cartelera.Solucion;

import main.java.ObjetosSimples.Cartelera.Solucion.excep.UsuarioException;

import java.util.HashMap;
import java.util.Map;

public class Cartelera {
    private String nombre;
    private final Map<String, Usuario> usuarios;

    public Cartelera(String nombre) {
        this.nombre = nombre;
        this.usuarios = new HashMap<>();
    }

    // --- Métodos públicos ---

    public void agregarUsuario(Usuario usuario) throws UsuarioException {
        if (this.esUsuarioRegistrado(usuario)) {
            throw new UsuarioException("El usuario ya está registrado en el sistema.");
        }
        this.usuarios.put(usuario.getCodigo(), usuario);
    }

    public void removerUsuario(Usuario usuario) throws UsuarioException {
        if (!this.esUsuarioRegistrado(usuario)) {
            throw new UsuarioException("El usuario no está registrado en el sistema.");
        }
        this.usuarios.remove(usuario.getCodigo());
    }

    // --- Helpers privados ---

    private boolean esUsuarioRegistrado(Usuario usuario) {
        return this.buscar(usuario.getCodigo()) == null;
    }

    private Usuario buscar(String usuarioId) {
        return this.usuarios.get(usuarioId);
    }
}
