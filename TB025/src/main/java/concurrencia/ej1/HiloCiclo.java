package main.java.concurrencia.ej1;

@SuppressWarnings("all")
public class HiloCiclo extends Thread {

    @Override
    public void run() {
        System.out.println("Estado del hilo en ejecución: "
                + Thread.currentThread().getState());
        try {
            Thread.sleep(1000); // Simula que el hilo está en espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}