package dosw.bitacora.semana3.patrones.ejercicio5;

/**
 * Forma - Abstracción en el patrón Bridge
 * Contiene una referencia a Color (el puente)
 */
public abstract class Forma {
    protected Color color;
    
    public Forma(Color color) {
        this.color = color;
    }
    
    public abstract void dibujar();
}
