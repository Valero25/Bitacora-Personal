package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * Ejercicio10 - Patrón Iterator
 * Un turista explora lugares emblemáticos de Roma iterando sobre una colección
 * sin exponer la estructura interna que almacena los lugares.
 */
public class Ejercicio10 {

    public static void main(String[] args) {

        TourRoute roma = new TourRoute();
        Tourist tourist = new Tourist();

        tourist.exploreTour(roma);
    }
}
