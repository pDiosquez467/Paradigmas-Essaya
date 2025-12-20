package main.java.concurrencia.hilosBasicos;

public class Orquestador {

    public static void main(String[] args) {
        // 1. Instancia del hilo que extiende Thread.
        Thread hilo = new Hilo("Hilo 1 (Extends)");
        // 2. Instancia del Runnable
        Runnable runnable = new OtroHilo("Hilo 2 (Runnable)");

        // Un Runnable por sí solo es una tarea, no un hilo.
        Thread otroHilo = new Thread(runnable);

        // 3. Inicializo ambos hilos
        hilo.start();
        otroHilo.start();

        System.out.println("El hilo Main terminó de lanzar los hilos.");
    }
}
