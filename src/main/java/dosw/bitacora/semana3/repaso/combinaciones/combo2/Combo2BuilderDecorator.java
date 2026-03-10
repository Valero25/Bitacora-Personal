package dosw.bitacora.semana3.repaso.combinaciones.combo2;

/**
 * ============================================================
 * COMBO 2: Builder + Decorator
 * ============================================================
 * ESCENARIO:
 *   Una pizzería permite armar pizzas personalizadas. La pizza tiene
 *   atributos base (tamaño, masa, salsa) que se configuran con Builder,
 *   y luego toppings opcionales ilimitados que se agregan con Decorator.
 *
 * POR QUÉ ESTOS DOS JUNTOS:
 *   Builder   → construye el objeto base de forma limpia y legible.
 *   Decorator → extiende ese objeto sin modificarlo ni crear subclases.
 *   Sin Decorator: necesitarías PizzaConQueso, PizzaConJamon,
 *                  PizzaConQuesoYJamon... explosión de clases.
 *   Sin Builder:   el constructor de PizzaBase tendría demasiados parámetros.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. PizzaBuilder construye PizzaBase paso a paso con encadenamiento:
 *      .tamano().masa().salsa().build()
 *      — el resultado es un objeto limpio con sus atributos base.
 *   2. Esa PizzaBase se pasa a ToppingQueso(pizza) — envuelve la pizza.
 *      Luego ToppingJamon(pizza) envuelve la pizza ya con queso.
 *      Cada decorador agrega su parte a descripcion() y precio().
 *   3. El cliente ve la pizza crecer capa a capa sin tocar PizzaBase.
 *
 * PUNTO DE UNIÓN:
 *   El Builder produce el componente base que el Decorator envuelve.
 *   Builder = construcción inicial → Decorator = extensión dinámica.
 * ============================================================
 */
public class Combo2BuilderDecorator {
    public static void main(String[] args) {
        // Builder crea la pizza base
        Pizza pizza = new PizzaBuilder()
                .tamano("Grande")
                .masa("gruesa")
                .salsa("BBQ")
                .build();

        System.out.println(pizza.descripcion() + " → $" + pizza.precio());

        // Decorator agrega toppings sin modificar la clase
        pizza = new ToppingQueso(pizza);
        pizza = new ToppingJamon(pizza);

        System.out.println(pizza.descripcion() + " → $" + pizza.precio());
    }
}
