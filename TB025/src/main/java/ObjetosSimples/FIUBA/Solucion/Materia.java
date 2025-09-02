package main.java.ObjetosSimples.FIUBA.Solucion;

import main.java.ObjetosSimples.FIUBA.Solucion.utils.TipoMateria;

public class Materia {
    private final String codigo;
    private final String nombre;
    private int cantidadDeCreditos;
    private TipoMateria tipo;

    public Materia(String codigo, String nombre, int cantidadDeCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadDeCreditos = cantidadDeCreditos;
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

    public TipoMateria getTipo(TipoMateria obligatoria) {
        return tipo;
    }

    public void setTipo(TipoMateria tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Materia materia)) return false;
        return this.codigo.equals(materia.getCodigo());
    }

    @Override
    public String toString() {
        return "Materia{" +
                "cantidadDeCreditos=" + cantidadDeCreditos +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
