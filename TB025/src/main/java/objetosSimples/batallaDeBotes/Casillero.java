package main.java.objetosSimples.batallaDeBotes;

public class Casillero<T> {

    private T valor;

    public Casillero() {
        this(null);
    }

    public Casillero(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return this.valor;
    }

    public boolean estaVacio() {
        return this.valor == null;
    }

    public void ocupar(T valor) {
        this.valor = valor;
    }

    public void vaciar() {
        this.valor = null;
    }
}
