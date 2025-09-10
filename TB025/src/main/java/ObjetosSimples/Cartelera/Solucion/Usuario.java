package main.java.ObjetosSimples.Cartelera.Solucion;

import main.java.ObjetosSimples.Cartelera.Solucion.excep.MensajeException;
import main.java.ObjetosSimples.Cartelera.Solucion.excep.UsuarioException;
import main.java.ObjetosSimples.Validaciones.Validaciones;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String codigo;
    private String nombre;
    private TipoUsuario tipo;
    private boolean activo;
    private final List<Mensaje> mensajesRecibidos;
    private final List<Mensaje> mensajesEnviados;

    public Usuario(String codigo, String nombre, TipoUsuario tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.activo = false;
        this.mensajesRecibidos = new ArrayList<>();
        this.mensajesEnviados = new ArrayList<>();
    }

    // --- Métodos públicos ---

    public void enviarMensaje(Usuario usuario, String texto) throws UsuarioException, IllegalArgumentException {
        this.transferirMensaje(this, usuario, texto);
    }

    public void recibirMensaje(Usuario usuario, String texto) throws UsuarioException, IllegalArgumentException {
        this.transferirMensaje(usuario, this, texto);
    }

    public String verMensajesRecibidos() throws UsuarioException {
        this.validarUsuarioActivo();
        return this.verMensajes(this.mensajesRecibidos, "Usuario: " + this + " - Mensajes recibidos:");
    }

    public String verMensajesEnviados() throws UsuarioException {
        this.validarUsuarioActivo();
        return this.verMensajes(this.mensajesEnviados, "Usuario: " + this + " - Mensajes enviados:");
    }

    public void iniciarSesion() {
        this.activo = true;
    }

    public void cerrarSesion() {
        this.activo = false;
    }

    public void salir() throws UsuarioException {
        this.validarUsuarioVerificado();
        System.exit(1);
    }

    // --- Sobre-escritura de métodos

    @Override
    public String toString() {
        return this.codigo + ", " + this.nombre;
    }


    // --- Helpers privados ---

    private void transferirMensaje(Usuario emisor, Usuario receptor, String contenido) throws UsuarioException, IllegalArgumentException {
        Validaciones.validarNotNull(emisor, "El emisor del mensaje no debe ser 'null'");
        Validaciones.validarNotNull(receptor, "El receptor del mensaje no debe ser 'null'");
        Validaciones.validarNotNull(contenido, "El contenido del mensaje no debe ser 'null'");
        Validaciones.validarNoVacio(contenido, "El contenido del mensaje no debe ser vacío");
        // Validaciones de usuario
        emisor.validarUsuario();
        receptor.validarUsuario();
        emisor.validarUsuarioActivo();

        Mensaje mensaje = new Mensaje(emisor, receptor, contenido);
        emisor.getMensajesEnviados().add(mensaje);
        receptor.mensajesRecibidos.add(mensaje);
    }


    private String verMensajes(List<Mensaje> mensajes, String texto) {
        StringBuilder sb = new StringBuilder(texto);
        mensajes.forEach(sb::append);
        return sb.toString();
    }

    private boolean esUsuarioAutenticado() {
        return this.tipo == TipoUsuario.HUESPED || this.tipo == TipoUsuario.PERSONAL;
    }

    private boolean esUsuarioVerificado() {
        return this.tipo == TipoUsuario.PERSONAL;
    }

    private boolean estaActivo() {
        return this.activo;
    }

    private void validarUsuario() throws UsuarioException {
        if (!this.esUsuarioAutenticado()) {
            throw new UsuarioException("El usuario no es válido.");
        }
    }

    private void validarUsuarioActivo() throws UsuarioException {
        if (this.estaActivo()) {
            throw new UsuarioException("El usuario que quiere enviar el mensaje no está activo.");
        }
    }

    private void validarUsuarioVerificado() throws UsuarioException {
        if (!this.esUsuarioVerificado()) {
            throw new UsuarioException("El usuario no está verificado.");
        }
    }

    // --- Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public List<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }
}