package main.java.objetosSimples.geometria;

import main.java.objetosSimples.validaciones.Validaciones;

public class Pincel implements Guardable {

    private Color color;

    public Pincel(Color color) {
        this.setColor(color);
    }

    public void seleccionarColor(Color color) {
        this.setColor(color);
    }

    public void pintar(Coloreable coloreable) {
        Validaciones.validarNotNull(coloreable, "coloreable");
        coloreable.colorearse(this.color);
    }

    private void setColor(Color color) {
        Validaciones.validarNotNull(color, "color");
        this.color = color;
    }

}
