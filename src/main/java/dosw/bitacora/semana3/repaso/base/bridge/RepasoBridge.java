package dosw.bitacora.semana3.repaso.base.bridge;

/**
 * ============================================================
 * PATRÓN: Bridge  (Estructural)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Si usas herencia para combinar dos dimensiones de variación
 *   (ej. forma × renderer), obtienes explosión de subclases:
 *   CirculoVectorial, CirculoRaster, CuadradoVectorial, etc.
 *   Bridge separa las dos dimensiones para que varíen independientemente.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   Dimensión 1 — Abstracción (FORMA): qué quiero dibujar.
 *     Forma (abstract) → Circulo, Cuadrado
 *   Dimensión 2 — Implementación (RENDERER): cómo lo dibujo.
 *     Renderer → RendererVectorial, RendererRaster
 *
 *   La CLAVE es que Forma tiene una referencia (el puente) a Renderer:
 *     public Forma(Renderer renderer)
 *   Así puedes combinar cualquier Forma con cualquier Renderer sin crear
 *   una subclase nueva para cada combinación.
 *
 * DIFERENCIA CON ADAPTER:
 *   Adapter arregla incompatibilidad entre clases YA EXISTENTES.
 *   Bridge se diseña desde el principio para separar dos jerarquías.
 *
 * DIAGRAMA MENTAL:
 *   Forma ────────── Renderer
 *   ├── Circulo      ├── RendererVectorial
 *   └── Cuadrado     └── RendererRaster
 *        (puente = referencia a Renderer inyectada por constructor)
 * ============================================================
 */
public class RepasoBridge {
    public static void main(String[] args) {
        Forma c1 = new Circulo(new RendererVectorial(), 5);
        Forma c2 = new Circulo(new RendererRaster(), 5);
        Forma q1 = new Cuadrado(new RendererVectorial(), 10);

        c1.dibujar();
        c2.dibujar();
        q1.dibujar();
    }
}
