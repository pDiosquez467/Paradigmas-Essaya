package main.java.concurrencia.ej1;

public class EjemploCicloDeVida {
    public static void main(String[] args) {
        HiloCiclo hilo = new HiloCiclo();
        // Estado: NEW
        System.out.println("Estado antes de iniciar: "  + hilo.getState());
        // Iniciar el hilo
        hilo.start(); // El hilo pasa al estado: RUNNABLE
        System.out.println("Estado después de iniciar: " + hilo.getState());
    }
}
