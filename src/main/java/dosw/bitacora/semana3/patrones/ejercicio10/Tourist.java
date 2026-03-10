package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * Tourist - Cliente del patrón Iterator
 * Recorre los lugares usando el iterador sin conocer la estructura interna de la colección
 */
public class Tourist {

    public void exploreTour(Aggregate<Place> route) {
        Iterator<Place> iterator = route.createIterator();

        while (iterator.hasNext()) {
            Place p = iterator.next();
            System.out.println("Visiting " + p.getName());
        }
    }
}
