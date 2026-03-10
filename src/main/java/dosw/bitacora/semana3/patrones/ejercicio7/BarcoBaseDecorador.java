package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * BarcoBaseDecorador - Decorador abstracto del patrón Decorator
 * Envuelve un Barco y delega las operaciones al componente decorado
 */
public abstract class BarcoBaseDecorador implements Barco {

    protected Barco barco;

    public BarcoBaseDecorador(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion();
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque();
    }

    @Override
    public int defensa() {
        return barco.defensa();
    }
}
