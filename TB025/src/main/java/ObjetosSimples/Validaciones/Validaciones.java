package main.java.ObjetosSimples.Validaciones;

import main.java.ObjetosSimples.Cartelera.Solucion.excep.MensajeException;

public class Validaciones {

    public static void validarNotNull(Object value, String mensaje) {
        if (value == null) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void validarNoVacio(String value, String mensaje) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
