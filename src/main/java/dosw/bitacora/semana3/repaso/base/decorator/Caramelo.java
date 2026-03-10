package dosw.bitacora.semana3.repaso.base.decorator;

public class Caramelo extends CafeDecorador {
    public Caramelo(Cafe cafe) { super(cafe); }

    @Override public String getDescripcion() { return cafe.getDescripcion() + " + Caramelo"; }
    @Override public double getCosto()       { return cafe.getCosto() + 0.75; }
}
