package dosw.bitacora.semana3.repaso.base.bridge;

/**
 * Abstracción: contiene una referencia a la implementación (el puente).
 * Varía independientemente del Renderer.
 */
public abstract class Forma {
    protected Renderer renderer;   // <-- el puente

    public Forma(Renderer renderer) { this.renderer = renderer; }

    public abstract void dibujar();
}
