package dosw.bitacora.semana3.repaso.base.builder;

/**
 * ============================================================
 * PATRÓN: Builder  (Creacional)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Crear objetos con muchos parámetros opcionales usando constructores
 *   resulta en código difícil de leer (constructor telescópico).
 *   Builder separa la construcción paso a paso del producto final.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. ComputadoraBuilder (interfaz) define los PASOS: buildCpu(),
 *      buildRam(), buildAlmacenamiento(), getResultado().
 *   2. ComputadoraGaming y ComputadoraOficina (concrete builders)
 *      implementan esos pasos con valores diferentes.
 *   3. Ensamblador (director) organiza el orden de los pasos.
 *      El cliente solo pide ensamblar() y luego getResultado().
 *
 * SEÑAL PARA USARLO:
 *   Cuando un constructor tiene más de 4 parámetros, muchos opcionales,
 *   o cuando el mismo proceso de construcción debe producir objetos distintos.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Armar una hamburguesa: los pasos son pan → carne → ingredientes → cierre.
 *   Una hamburguesa vegana usa los mismos pasos pero con ingredientes distintos.
 *
 * DIAGRAMA MENTAL:
 *   Ensamblador (director)
 *       └── usa── ComputadoraBuilder (interfaz)
 *                    ├── ComputadoraGaming  → Computadora(gamer)
 *                    └── ComputadoraOficina → Computadora(oficina)
 * ============================================================
 */
public class RepasoBuilder {
    public static void main(String[] args) {
        Ensamblador director = new Ensamblador();

        ComputadoraBuilder gamer = new ComputadoraGaming();
        director.ensamblar(gamer);
        System.out.println(gamer.getResultado());

        ComputadoraBuilder oficina = new ComputadoraOficina();
        director.ensamblar(oficina);
        System.out.println(oficina.getResultado());
    }
}
