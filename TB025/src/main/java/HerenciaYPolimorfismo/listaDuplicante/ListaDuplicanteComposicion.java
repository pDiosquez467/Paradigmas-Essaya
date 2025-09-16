package main.java.HerenciaYPolimorfismo.listaDuplicante;

import java.util.ArrayList;

public class ListaDuplicanteComposicion<T> {
    private final ArrayList<T> elementos;

    public ListaDuplicanteComposicion() {
        this.elementos = new ArrayList<>();
    }

    public T get(int index) {
        return elementos.get(index);
    }

    public boolean add(T nuevo) {
        boolean agregado = elementos.add(nuevo);
        elementos.add(nuevo);
        return agregado;
    }

    public int size() {
        return elementos.size();
    }
}
