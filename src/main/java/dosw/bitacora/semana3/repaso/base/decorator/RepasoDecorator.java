package dosw.bitacora.semana3.repaso.base.decorator;

/**
 * ============================================================
 * PATRÓN: Decorator  (Estructural)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Quieres agregar comportamiento a un objeto en tiempo de ejecución
 *   sin modificar su clase ni usar herencia. La herencia agrega
 *   comportamiento a TODA la clase; el Decorator lo agrega a UNA instancia.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Cafe (interfaz) define getDescripcion() y getCosto().
 *   2. CafeSimple (componente concreto) es el objeto base sin adornos.
 *   3. CafeDecorador (decorador abstracto) implementa Cafe y TIENE UN Cafe
 *      — envuelve al componente y delega por defecto.
 *   4. Leche y Caramelo (decoradores concretos) sobreescriben getCosto()
 *      y getDescripcion() añadiendo su parte al resultado del componente.
 *   5. Puedes apilar decoradores uno sobre otro (like layers):
 *      new Caramelo(new Leche(new CafeSimple()))
 *
 * SEÑAL PARA USARLO:
 *   Quieres combinaciones abiertas sin explosión de subclases.
 *   Ej: CafeConLecheYCaramelo, CafeConDobleLeche, etc.
 *      todas se logran componiendo, no creando nuevas clases.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Un sándwich: empiezas con el pan (base) y vas "decorando":
 *   + queso, + jamón, + mostaza — cada capa añade algo.
 *
 * DIAGRAMA MENTAL:
 *   Cafe ← CafeSimple (base)
 *   Cafe ← CafeDecorador (abstract, tiene un Cafe)
 *              ├── Leche      (agrega +leche, +$0.50)
 *              └── Caramelo   (agrega +caramelo, +$0.75)
 * ============================================================
 */
public class RepasoDecorator {
    public static void main(String[] args) {
        Cafe c = new CafeSimple();
        System.out.println(c.getDescripcion() + " $" + c.getCosto());

        c = new Leche(c);
        System.out.println(c.getDescripcion() + " $" + c.getCosto());

        c = new Caramelo(c);
        System.out.println(c.getDescripcion() + " $" + c.getCosto());
    }
}
