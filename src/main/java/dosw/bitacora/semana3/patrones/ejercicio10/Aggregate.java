package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * Aggregate - Interfaz del patrón Iterator
 * Representa cualquier colección que pueda producir un iterador
 */
public interface Aggregate<T> {
    Iterator<T> createIterator();
}
