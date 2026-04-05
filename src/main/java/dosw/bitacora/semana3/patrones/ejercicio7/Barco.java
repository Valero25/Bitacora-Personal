package dosw.bitacora.semana3.patrones.ejercicio7;

/**
 * Barco - Interfaz del patrón Decorator
 * Define el contrato base para todos los barcos y sus decoradores
 */
public interface Barco {
    String getDescripcion();
    int poderAtaque();
    int defensa();
}
