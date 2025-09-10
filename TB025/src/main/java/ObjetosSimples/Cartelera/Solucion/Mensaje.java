package main.java.ObjetosSimples.Cartelera.Solucion;

import java.time.LocalDateTime;

public class Mensaje {
    private Usuario emisor;
    private Usuario receptor;
    private String texto;
    private LocalDateTime fecha;

    public Mensaje(Usuario emisor, Usuario receptor, String texto) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.texto = texto;
        this.fecha = LocalDateTime.now();
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
