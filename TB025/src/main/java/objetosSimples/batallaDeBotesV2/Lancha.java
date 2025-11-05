package main.java.objetosSimples.batallaDeBotesV2;

public class Lancha extends Bote{

    public Lancha(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }

    @Override
    public void recibirDisparo(TipoDeDisparo tipoDeDisparo) {
        if (tipoDeDisparo.equals(TipoDeDisparo.CONVENCIONAL)) {
            this.setVidaActual(this.getVidaActual() / 2);
            return;
        }
        this.setVidaActual(0);
    }
}
