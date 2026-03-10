package dosw.bitacora.semana3.patrones.ejercicio10;

/**
 * Iterator - Interfaz del patrón Iterator
 * Define el contrato para recorrer una colección sin exponer su estructura interna
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
