package dosw.bitacora.semana3.repaso.base.builder;

/**
 * Builder: define los pasos para construir el producto.
 * Cada paso puede tener una implementación diferente.
 */
public interface ComputadoraBuilder {
    void buildCpu();
    void buildRam();
    void buildAlmacenamiento();
    Computadora getResultado();
}
