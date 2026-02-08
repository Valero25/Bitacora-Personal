package dosw.bitacora.semana3.patrones.ejercicio6;

/**
 * ItemBodega - Componente base del patrón Composite
 * Define la interfaz común para productos individuales y cajas compuestas
 */
public interface ItemBodega {
    double getPrecio();
    void mostrar(int nivel);
}
