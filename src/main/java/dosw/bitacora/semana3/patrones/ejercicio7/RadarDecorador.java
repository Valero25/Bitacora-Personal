package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * RadarDecorador - Decorador concreto del patrón Decorator
 * Añade +10 en ataque al barco decorado
 */
public class RadarDecorador extends BarcoBaseDecorador {

    public RadarDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + " + Radar Avanzado";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 10;
    }
}
