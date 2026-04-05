package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * RomeIterator - Iterador concreto del patrón Iterator
 * Recorre el arreglo de lugares de Roma sin exponer su estructura interna
 */
public class RomeIterator implements Iterator<Place> {

    private final Place[] places;
    private int currentIndex = 0;

    public RomeIterator(Place[] places) {
        this.places = places;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < places.length;
    }

    @Override
    public Place next() {
        return places[currentIndex++];
    }
}
