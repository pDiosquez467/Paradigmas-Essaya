package main.java.objetosSimples.geometria;

import main.java.objetosSimples.validaciones.Validaciones;

public class Circulo implements FiguraGeometrica, Coloreable{

    private final double radio;
    private Color color;

    public Circulo(double radio) {
        Validaciones.validarMayorACero(radio, "radio");
        this.radio = radio;
        this.color = null;
    }

    @Override
    public double calcularSuperficie() {
        return Math.PI * this.radio * this.radio;
    }

    @Override
    public void colorearse(Color color) {
        this.color = color;
    }

    public double radio() {
        return radio;
    }

    public Color color() {
        return color;
    }
}
