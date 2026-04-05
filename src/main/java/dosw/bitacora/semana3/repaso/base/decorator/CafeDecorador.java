package dosw.bitacora.semana3.repaso.base.decorator;

/**
 * Decorador base: envuelve un Cafe y delega.
 * Las subclases extienden el comportamiento sin modificar CafeSimple.
 */
public abstract class CafeDecorador implements Cafe {
    protected Cafe cafe;

    public CafeDecorador(Cafe cafe) { this.cafe = cafe; }

    @Override public String getDescripcion() { return cafe.getDescripcion(); }
    @Override public double getCosto()       { return cafe.getCosto(); }
}
