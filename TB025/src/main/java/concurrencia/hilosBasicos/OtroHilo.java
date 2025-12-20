package main.java.concurrencia.hilosBasicos;

@SuppressWarnings("all")
public record OtroHilo(String name) implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Saludos desde " + this.name());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
