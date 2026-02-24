package dosw.bitacora.semana3.repaso.base.iterator;

/** Colección que produce su propio iterador */
public interface Coleccion<T> {
    Iterador<T> crearIterador();
}
