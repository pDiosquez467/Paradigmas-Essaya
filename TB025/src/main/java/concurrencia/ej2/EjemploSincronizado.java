package main.java.concurrencia.ej2;

public class EjemploSincronizado {

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread hilo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        Thread otroHilo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        hilo.start();
        otroHilo.start();
        hilo.join();
        otroHilo.join();

        System.out.println("Valor inicial del contador: " + contador.getValor());
    }
}
