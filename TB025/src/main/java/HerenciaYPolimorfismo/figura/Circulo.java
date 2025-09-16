package main.java.HerenciaYPolimorfismo.figura;

record Circulo(double radio) implements Figura {

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radio, 2);
    }
}
