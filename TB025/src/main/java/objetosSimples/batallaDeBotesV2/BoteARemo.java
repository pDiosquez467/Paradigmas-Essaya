package main.java.objetosSimples.batallaDeBotesV2;

public class BoteARemo extends Bote {
    public BoteARemo(String nombre, int vidaMaxima) {
        super(nombre, vidaMaxima);
    }

    @Override
    public void recibirDisparo(TipoDeDisparo tipoDeDisparo) {
        this.setVidaActual(0);
    }
}
