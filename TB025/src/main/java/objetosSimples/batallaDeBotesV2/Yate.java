package main.java.objetosSimples.batallaDeBotesV2;

public class Yate extends Bote {

    public Yate(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }

    @Override
    public void recibirDisparo(TipoDeDisparo tipoDeDisparo) {
        if (tipoDeDisparo.equals(TipoDeDisparo.MISIL)) {
            this.setVidaActual(0);
        }
    }
}
