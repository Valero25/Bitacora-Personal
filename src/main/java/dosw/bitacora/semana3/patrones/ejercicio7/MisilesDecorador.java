package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * MisilesDecorador - Decorador concreto del patrón Decorator
 * Añade +40 en ataque al barco decorado
 */
public class MisilesDecorador extends BarcoBaseDecorador {

    public MisilesDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + " + Misiles";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 40;
    }
}
