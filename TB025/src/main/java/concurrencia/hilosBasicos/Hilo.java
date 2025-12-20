package main.java.concurrencia.hilosBasicos;

@SuppressWarnings("all")
public class Hilo extends Thread{

    public Hilo(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Saludos desde " + this.getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
