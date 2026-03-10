package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * BlindajeDecorador - Decorador concreto del patrón Decorator
 * Añade +30 en defensa al barco decorado
 */
public class BlindajeDecorador extends BarcoBaseDecorador {

    public BlindajeDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + " + Blindaje Reforzado";
    }

    @Override
    public int defensa() {
        return barco.defensa() + 30;
    }
}
