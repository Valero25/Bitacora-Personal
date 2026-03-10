package dosw.bitacora.semana3.repaso.base.decorator;

public class Leche extends CafeDecorador {
    public Leche(Cafe cafe) { super(cafe); }

    @Override public String getDescripcion() { return cafe.getDescripcion() + " + Leche"; }
    @Override public double getCosto()       { return cafe.getCosto() + 0.5; }
}
