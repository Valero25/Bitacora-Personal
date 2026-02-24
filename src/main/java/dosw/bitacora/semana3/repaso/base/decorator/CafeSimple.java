package dosw.bitacora.semana3.repaso.base.decorator;

public class CafeSimple implements Cafe {
    @Override public String getDescripcion() { return "Cafe"; }
    @Override public double getCosto()       { return 1.0; }
}
