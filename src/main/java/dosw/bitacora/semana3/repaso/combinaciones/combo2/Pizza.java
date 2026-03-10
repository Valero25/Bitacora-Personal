package dosw.bitacora.semana3.repaso.combinaciones.combo2;

/**
 * COMBO 2: Builder + Decorator
 * ─────────────────────────────
 * Problema: Queremos construir pizzas con ingredientes base (Builder) y
 * luego agregar toppings extra dinámicamente (Decorator) sin crear
 * subclases para cada combinación posible.
 *
 * Builder   → construye el objeto Pizza base con sus atributos definidos.
 * Decorator → envuelve la pizza para agregar descripción y costo extra.
 */
public interface Pizza {
    String descripcion();
    double precio();
}
