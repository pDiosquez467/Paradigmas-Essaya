package main.java.ObjetosSimples.FIUBA.Solucion;

import main.java.ObjetosSimples.FIUBA.Solucion.utils.TipoMateria;

public class Materia {
    private final String codigo;
    private final String nombre;
    private int cantidadDeCreditos;
    private TipoMateria tipo;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidadDeCreditos() {
        return cantidadDeCreditos;
    }

    public TipoMateria getTipo() {
        return tipo;
    }

    public void setCantidadDeCreditos(int cantidadDeCreditos) {
        this.cantidadDeCreditos = cantidadDeCreditos;
    }

    public void setTipo(TipoMateria tipo) {
        this.tipo = tipo;
    }
}
