package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * AntiTorpedosDecorador - Decorador concreto del patrón Decorator
 * Añade +20 en ataque al barco decorado
 */
public class AntiTorpedosDecorador extends BarcoBaseDecorador {

    public AntiTorpedosDecorador(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion() + " + Sistema AntiTorpedos";
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque() + 20;
    }
}
