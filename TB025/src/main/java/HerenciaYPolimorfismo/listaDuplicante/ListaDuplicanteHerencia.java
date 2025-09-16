package main.java.HerenciaYPolimorfismo.listaDuplicante;

import java.util.ArrayList;

public class ListaDuplicanteHerencia<T> extends ArrayList<T> {

    @Override
    public boolean add(T nuevo) {
        super.add(nuevo);
        super.add(nuevo);
        return true;
    }
}
