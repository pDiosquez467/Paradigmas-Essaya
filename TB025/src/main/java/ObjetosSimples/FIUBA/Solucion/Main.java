package main.java.ObjetosSimples.FIUBA.Solucion;

import main.java.ObjetosSimples.FIUBA.Solucion.utils.TipoMateria;

public class Main {
    public static void main(String[] args) throws Exception {
        // Creación de carreras
        Carrera ingenieriaInformatica = new Carrera(
                "FI 025 UBA",
                "Ingeniería Informática",
                120
        );

        Carrera ingenieriaElectronica = new Carrera(
                "FI 02 UBA",
                "Ingeniería Electrónica",
                140
        );

        Carrera licenciaturaEnComputacion = new Carrera(
                "FI 03 UBA",
                "Licenciatura en Computación",
                100
        );

        FIUBA.agregarCarrera(ingenieriaInformatica);
        FIUBA.agregarCarrera(ingenieriaElectronica);
        FIUBA.agregarCarrera(licenciaturaEnComputacion);

        // Creación de materias para cada carrera
        // Materias de Ingeniería Informática
        Materia paradigmas = new Materia("TB025", "Paradigmas de Programación", 12);
        paradigmas.setTipo(TipoMateria.OBLIGATORIA);

        Materia estructuras = new Materia("TB026", "Estructuras de Datos", 10);
        estructuras.setTipo(TipoMateria.OBLIGATORIA);

        Materia algoritmos = new Materia("TB027", "Algoritmos y Programación III", 12);
        algoritmos.setTipo(TipoMateria.OBLIGATORIA);

        Materia inteligenciaArtificial = new Materia("TB028", "Inteligencia Artificial", 8);
        inteligenciaArtificial.setTipo(TipoMateria.OPTATIVA);

        // Materias de Ingeniería Electrónica
        Materia electronicaBasica = new Materia("TE001", "Electrónica Básica", 10);
        electronicaBasica.setTipo(TipoMateria.OBLIGATORIA);

        Materia microcontroladores = new Materia("TE002", "Sistemas Microprogramables", 12);
        microcontroladores.setTipo(TipoMateria.OBLIGATORIA);

        Materia sistemasDigitales = new Materia("TE003", "Sistemas Digitales", 10);
        sistemasDigitales.setTipo(TipoMateria.OBLIGATORIA);

        // Agregar materias a las carreras
        FIUBA.agregarMateriaACarrera(paradigmas, ingenieriaInformatica);
        FIUBA.agregarMateriaACarrera(paradigmas, licenciaturaEnComputacion);
        FIUBA.agregarMateriaACarrera(estructuras, ingenieriaInformatica);
        FIUBA.agregarMateriaACarrera(algoritmos, ingenieriaInformatica);
        FIUBA.agregarMateriaACarrera(inteligenciaArtificial, ingenieriaInformatica);

        FIUBA.agregarMateriaACarrera(electronicaBasica, ingenieriaElectronica);
        FIUBA.agregarMateriaACarrera(microcontroladores, ingenieriaElectronica);
        FIUBA.agregarMateriaACarrera(sistemasDigitales, ingenieriaElectronica);

        // Creación de alumnos (personajes humanos de Pokémon)
        Alumno ashKetchum = new Alumno("113457", "Ash Ketchum");
        Alumno brock = new Alumno("113458", "Brock");
        Alumno misty = new Alumno("113459", "Misty");
        Alumno garyOak = new Alumno("113460", "Gary Oak");
        Alumno iris = new Alumno("113461", "Iris");
        Alumno cynthia = new Alumno("113462", "Cynthia");

        // Agregar alumnos a FIUBA
        FIUBA.agregarAlumno(ashKetchum);
        FIUBA.agregarAlumno(brock);
        FIUBA.agregarAlumno(misty);
        FIUBA.agregarAlumno(garyOak);
        FIUBA.agregarAlumno(iris);
        FIUBA.agregarAlumno(cynthia);

        // Inscribir alumnos en carreras
        FIUBA.inscribirseA(ashKetchum, ingenieriaInformatica);
        FIUBA.inscribirseA(brock, ingenieriaElectronica);
        FIUBA.inscribirseA(misty, licenciaturaEnComputacion);
        FIUBA.inscribirseA(garyOak, ingenieriaInformatica);
        FIUBA.inscribirseA(iris, ingenieriaElectronica);
        FIUBA.inscribirseA(cynthia, ingenieriaElectronica);

        // Aprobar materias
        FIUBA.aprobarMateria(ashKetchum, paradigmas);
        FIUBA.aprobarMateria(ashKetchum, estructuras);
        FIUBA.aprobarMateria(brock, electronicaBasica);
        FIUBA.aprobarMateria(misty, paradigmas);
        FIUBA.aprobarMateria(garyOak, algoritmos);
        FIUBA.aprobarMateria(iris, microcontroladores);
        FIUBA.aprobarMateria(cynthia, sistemasDigitales);

        // Consultar estados académicos
        System.out.println("Estado académico de Ash Ketchum:");
        System.out.println(FIUBA.consultarEstadoAcademico(ashKetchum));

        System.out.println("\nEstado académico de Brock:");
        System.out.println(FIUBA.consultarEstadoAcademico(brock));

        System.out.println("\nEstado académico de Misty:");
        System.out.println(FIUBA.consultarEstadoAcademico(misty));
    }
}
