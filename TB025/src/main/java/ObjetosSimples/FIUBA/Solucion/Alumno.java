package main.java.ObjetosSimples.FIUBA.Solucion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Alumno {
    private final String legajo;
    private final String nombre;
    private final HashMap<Carrera, List<Materia>> carreras;

    public Alumno(String legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.carreras = new HashMap<>();
    }

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void inscribirseACarrera(Carrera carrera) throws Exception {
        if (this.estaInscriptoEn(carrera)) {
            throw new Exception("El alumno ya está inscripto en esta carrera!");
        }
        this.carreras.put(carrera, new ArrayList<>());
    }

    public void marcarMateriaComoAprobada(Materia materia) throws Exception {
        if (!this.estaInscriptoEn(materia)) {
            throw new Exception("El alumno no está inscripto en esta materia!");
        }

        for (Carrera carrera: carreras.keySet()) {
            if (carrera.perteneceAlPlanDeEstudios(materia)) this.carreras.get(carrera).add(materia);
        }

    }

    public String consultarEstadoDeCarreras() {
        StringBuilder sb = new StringBuilder();
        for (Carrera carrera: this.carreras.keySet()) {
            sb.append(carrera.toString()).append("\nMaterias aprobadas:");
            for (Materia materia: this.carreras.get(carrera)) {
                sb.append(materia.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Boolean estaInscriptoEn(Materia materia) {
        for (Carrera carrera: carreras.keySet()) {
            if (carrera.perteneceAlPlanDeEstudios(materia)) return true;
        }
        return false;
    }

    private Boolean estaInscriptoEn(Carrera carrera) {
        return this.carreras.containsKey(carrera);
    }
}