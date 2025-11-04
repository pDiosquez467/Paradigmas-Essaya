package main.java.objetosSimples.geometria;

import main.java.objetosSimples.validaciones.Validaciones;

public class Compas implements Guardable {

    public Circulo dibujarCirculoConRadio(double radio) {
        Validaciones.validarMayorACero(radio, "radio");
        return new Circulo(radio);
    }
}
