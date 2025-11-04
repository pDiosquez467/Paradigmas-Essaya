package main.java.objetosSimples.geometria;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Compas unCompas = new Compas();
        Cartuchera unaCartuchera = new Cartuchera();

        Color colorRojo = new Rojo();

        Pincel pincelA = new Pincel(colorRojo);
        Pincel pincelB = new Pincel(colorRojo);

        Circulo unCirculo = unCompas.dibujarCirculoConRadio(5.0);

        unaCartuchera.guardar(pincelA, pincelB, unCompas);

        List<Pincel> pincelesEncontrados = unaCartuchera.getPinceles();
        Pincel pincelParaUsar = pincelesEncontrados.get(0);

        if (pincelParaUsar == null) {
            System.out.println("No se pudo obtener un pincel de la cartuchera.");
            return;
        }

        pincelParaUsar.seleccionarColor(colorRojo);
        pincelParaUsar.pintar(unCirculo);

        double superficie = unCirculo.calcularSuperficie();

        System.out.println("El radio del círculo es: " + unCirculo.radio());
        System.out.println("La superficie calculada es: " + superficie);
        System.out.println("El color del círculo es: " + unCirculo.color().getClass().getSimpleName());
        System.out.println("El círculo fue coloreado: " + (unCirculo.color() != null));
    }
}
