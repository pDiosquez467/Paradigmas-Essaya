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

    public void agregarMateriaAPlanDeEstudios(Materia materia) throws Exception {
        if (this.perteneceAlPlanDeEstudios(materia))
            throw new Exception("Esta materia ya pertenece al plan de estudios");
        this.materias.add(materia);
    }

    public Boolean perteneceAlPlanDeEstudios(Materia otra) {
        for (Materia materia: this.materias) {
            if (materia.equals(otra)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Carrera carrera)) return false;
        return this.codigo.equals(carrera.getCodigo());
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", cantidadMinimaCreditos=" + cantidadMinimaCreditos +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
