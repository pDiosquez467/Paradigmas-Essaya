package main.java.ObjetosSimples.FIUBA.Solucion;

import java.util.*;

public class FIUBA {

    private static List<Carrera> carreras;

    private static HashMap<Alumno, List<Carrera>> alumnos;

    public void agregarCarrera(Carrera carrera) throws Exception {
        if (existeCarrera(carrera)) throw new Exception("Esta carrera ya existe en la Facultad!");
        carreras.add(carrera);
    }

    public boolean existeCarrera(Carrera carrera) {
        return existeEn(carrera, Collections.singleton(carreras));
    }

    public void agregarAlumno(Alumno alumno) throws Exception {
        if (existeAlumno(alumno)) throw new Exception("Este alumno ya existe en la Facultad!");
        alumnos.put(alumno, new ArrayList<>());
    }

    public boolean existeAlumno(Alumno alumno) {
        return existeEn(alumno, Collections.singleton(alumnos.keySet()));
    }

    private Boolean existeEn(Object obj, Collection<Object> coleccion) {
        for (Object object: coleccion) {
            if (object.equals(obj)) return true;
        }
        return false;
    }

    public void inscribirseA(Alumno alumno, Carrera carrera) throws Exception {
        alumnos.get(alumno).add(carrera);
        alumno.inscribirseACarrera(carrera);
    }

    public void aprobarMateria(Alumno alumno, Materia materia) throws Exception{
        alumno.marcarMateriaComoAprobada(materia);
    }

    public String consultarEstadoAcademico(Alumno alumno) {
        return alumno.verEstadoDeCarreras();
    }

}
