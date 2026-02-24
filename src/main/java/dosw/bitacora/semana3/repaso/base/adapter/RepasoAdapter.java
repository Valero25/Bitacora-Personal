package dosw.bitacora.semana3.repaso.base.adapter;

/**
 * ============================================================
 * PATRÓN: Adapter  (Estructural)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Tienes código existente (legacy) con una interfaz incompatible
 *   con la que el cliente espera. No puedes modificar la clase legacy.
 *   El Adapter actúa como un «enchufe» que hace compatibles ambas partes.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Reproductor (interfaz target) es lo que el cliente necesita:
 *      reproducir(String archivo).
 *   2. ReproductorLegacy (adaptee) es la clase antigua con la interfaz
 *      incompatible: playFile(String path).
 *   3. ReproductorAdapter (adapter) implementa Reproductor y dentro
 *      llama a ReproductorLegacy.playFile() — traduce la llamada.
 *   4. El cliente solo crea un ReproductorAdapter; nunca toca Legacy.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Un adaptador de corriente eléctrica: el enchufe europeo (legacy)
 *   no cabe en un tomacorriente americano (target). El adaptador físico
 *   hace compatibles las dos interfaces sin modificar ninguna.
 *
 * DIAGRAMA MENTAL:
 *   Cliente → Reproductor ← ReproductorAdapter → ReproductorLegacy
 *              (target)         (adapter)              (adaptee)
 * ============================================================
 */
public class RepasoAdapter {
    public static void main(String[] args) {
        Reproductor r = new ReproductorAdapter(new ReproductorLegacy());
        r.reproducir("cancion.mp3");
    }
}
