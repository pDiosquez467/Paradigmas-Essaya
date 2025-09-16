package main.java.HerenciaYPolimorfismo.figura;

class Cuadrado extends Rectangulo implements Figura {
    public Cuadrado(double lado) {
        super(lado, lado);
    }
}
