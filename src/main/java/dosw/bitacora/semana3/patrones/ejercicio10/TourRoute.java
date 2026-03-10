package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * TourRoute - Colección concreta del patrón Iterator
 * Almacena los lugares de Roma y produce un iterador sin exponer su estructura interna
 */
public class TourRoute implements Aggregate<Place> {

    private final Place[] places;

    public TourRoute() {
        places = new Place[]{
                new Place("Colosseum"),
                new Place("Roman Forum"),
                new Place("Trevi Fountain"),
                new Place("Pantheon"),
                new Place("Spanish Steps")
        };
    }

    @Override
    public Iterator<Place> createIterator() {
        return new RomeIterator(places);
    }
}
