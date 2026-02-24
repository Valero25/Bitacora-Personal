package dosw.bitacora.semana3.repaso.base.iterator;

/**
 * ============================================================
 * PATRÓN: Iterator  (Comportamiento)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Quieres recorrer los elementos de una colección sin exponer
 *   cómo está implementada internamente (array, lista enlazada,
 *   árbol, etc.). El cliente usa la misma interfaz sin importar.
 *
 * ROL DE CADA CLASE:
 *   Iterador<T>     (interfaz)         → hasNext(), next()
 *   Coleccion<T>    (interfaz)         → crearIterador() — la colección
 *                                        sabe cómo crear su propio iterador
 *   ListaNumeros    (colección concreta)→ almacena int[], crea NumerosIterador
 *   NumerosIterador (iterador concreto) → mantiene el índice actual
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Creas la colección: new ListaNumeros(10, 20, 30, 40, 50).
 *   2. Pides el iterador: lista.crearIterador().
 *   3. Avanzas con el ciclo while(it.hasNext()) { it.next() }.
 *   4. La colección interna podría cambiar de int[] a ArrayList y
 *      el código del cliente NO cambiaría.
 *
 * DIFERENCIA CON FOR-EACH DE JAVA:
 *   Java ya usa este patrón: Iterable + Iterator. Este ejercicio
 *   muestra la mecánica interna usando interfaces propias.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   El control remoto de un televisor: puedes pasar canales con
 *   siguiente() sin saber cómo están almacenados internamente.
 * ============================================================
 */
public class RepasoIterator {
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(10, 20, 30, 40, 50);
        Iterador<Integer> it = lista.crearIterador();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
