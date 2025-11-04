package main.java.objetosSimples.geometria;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cartuchera {

    private final List<Guardable> utiles;

    public Cartuchera() {
        this.utiles = new ArrayList<>();
    }

    public void guardar(Guardable ...guardables) {
        Validaciones.validarNotNull(guardables, "guardable");
        this.utiles.addAll(List.of(guardables));
    }

    public List<Pincel> getPinceles() {
        return this.utiles.stream()
                .filter(guardable -> guardable instanceof Pincel)
                .map(guardable -> (Pincel) guardable)
                .toList();
    }

    public List<Guardable> utiles() {
        return Collections.unmodifiableList(this.utiles);
    }
}
