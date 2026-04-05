package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * BarcoBase - Componente concreto del patrón Decorator
 * Representa un barco básico sin mejoras
 */
public class BarcoBase implements Barco {

    @Override
    public String getDescripcion() {
        return "Barco Base";
    }

    @Override
    public int poderAtaque() {
        return 10;
    }

    @Override
    public int defensa() {
        return 10;
    }
}
