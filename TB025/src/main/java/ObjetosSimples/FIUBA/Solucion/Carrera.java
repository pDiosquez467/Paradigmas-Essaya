package main.java.ObjetosSimples.FIUBA.Solucion;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private final String codigo;
    private final String nombre;
    private final List<Materia> materias;
    private final int cantidadMinimaCreditos;

    public Carrera(String codigo, String nombre, int cantidadMinimaCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.materias = new ArrayList<>();
        this.cantidadMinimaCreditos = cantidadMinimaCreditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public int getCantidadMinimaCreditos() {
        return cantidadMinimaCreditos;
    }
}
