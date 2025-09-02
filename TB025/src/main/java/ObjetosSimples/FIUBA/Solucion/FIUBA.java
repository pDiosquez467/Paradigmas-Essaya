package main.java.ObjetosSimples.FIUBA.Solucion;

import java.util.*;

public class FIUBA {

    private static final List<Carrera> carreras = new ArrayList<>();
    private static final HashMap<Alumno, List<Carrera>> alumnos = new HashMap<>();

    public static void agregarCarrera(Carrera carrera) throws Exception {
        if (existeCarrera(carrera)) throw new Exception("Esta carrera ya existe en la Facultad!");
        carreras.add(carrera);
    }

    public static boolean existeCarrera(Carrera carrera) {
        return existeEn(carrera, Collections.singleton(carreras));
    }

    public static void agregarAlumno(Alumno alumno) throws Exception {
        if (existeAlumno(alumno)) throw new Exception("Este alumno ya existe en la Facultad!");
        alumnos.put(alumno, new ArrayList<>());
    }

    public static boolean existeAlumno(Alumno alumno) {
        return existeEn(alumno, Collections.singleton(alumnos.keySet()));
    }

    private static boolean existeEn(Object obj, Collection<Object> coleccion) {
        for (Object object: coleccion) {
            if (object.equals(obj)) return true;
        }
        return false;
    }

    public static void agregarMateriaACarrera(Materia materia, Carrera carrera) throws Exception {
        carrera.agregarMateriaAPlanDeEstudios(materia);
    }

    public static void inscribirseA(Alumno alumno, Carrera carrera) throws Exception {
        alumnos.get(alumno).add(carrera);
        alumno.inscribirseACarrera(carrera);
    }

    public static void aprobarMateria(Alumno alumno, Materia materia) throws Exception{
        alumno.marcarMateriaComoAprobada(materia);
    }

    public static String consultarEstadoAcademico(Alumno alumno) {
        return alumno.verEstadoDeCarreras();
    }

}
