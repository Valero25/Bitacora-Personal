package dosw.bitacora.semana3.repaso.base.strategy;

/**
 * ============================================================
 * PATRÓN: Strategy  (Comportamiento)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Tienes un algoritmo que puede variar (ordenar, calcular rutas,
 *   comprimir, etc.) y no quieres llenar el contexto con if/else
 *   o switch para cada variante. Strategy encapsula cada algoritmo
 *   en su propia clase y los hace intercambiables.
 *
 * ROL DE CADA CLASE:
 *   Ordenamiento         (estrategia/interfaz) → ordenar(int[])
 *   OrdenamientoBurbuja  (estrategia concreta) → implementación Burbuja
 *   OrdenamientoQuick    (estrategia concreta) → usa Arrays.sort()
 *   Sorter               (contexto)            → tiene un Ordenamiento,
 *                                                delega ordenar() a él
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. El contexto (Sorter) no sabe qué algoritmo usa; solo llama
 *      estrategia.ordenar(datos).
 *   2. Al crear Sorter, inyectas la estrategia inicialmente:
 *      new Sorter(new OrdenamientoBurbuja())
 *   3. Puedes cambiar el algoritmo EN TIEMPO DE EJECUCIÓN:
 *      sorter.setEstrategia(new OrdenamientoQuick())
 *      — sin cambiar ningún otro código.
 *
 * DIFERENCIA CON TEMPLATE METHOD:
 *   Template Method usa herencia; el algoritmo varía mediante sobreescritura.
 *   Strategy usa composición; el algoritmo varía mediante intercambio de objeto.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Una app de GPS: puedes elegir la estrategia de ruta — más rápida,
 *   más barata, evitar autopistas. El contexto (navegación) no cambia;
 *   solo se intercambia la estrategia.
 * ============================================================
 */
public class RepasoStrategy {
    public static void main(String[] args) {
        Sorter sorter = new Sorter(new OrdenamientoBurbuja());
        sorter.ordenar(new int[]{5, 3, 1, 4, 2});

        sorter.setEstrategia(new OrdenamientoQuick());
        sorter.ordenar(new int[]{5, 3, 1, 4, 2});
    }
}
