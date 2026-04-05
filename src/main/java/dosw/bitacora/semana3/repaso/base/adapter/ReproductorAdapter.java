package dosw.bitacora.semana3.repaso.base.adapter;

/**
 * Adapter: traduce la interfaz del Adaptee a la interfaz Target.
 * El cliente solo conoce Reproductor, nunca ReproductorLegacy.
 */
public class ReproductorAdapter implements Reproductor {
    private ReproductorLegacy legacy;

    public ReproductorAdapter(ReproductorLegacy legacy) {
        this.legacy = legacy;
    }

    @Override
    public void reproducir(String archivo) {
        legacy.playFile(archivo);   // <-- traducción
    }
}
