package dosw.bitacora.semana3.repaso.base.builder;

/**
 * Director: conoce el orden de los pasos pero no los detalles de construcción.
 * Los detalles los maneja el builder concreto.
 */
public class Ensamblador {
    public void ensamblar(ComputadoraBuilder builder) {
        builder.buildCpu();
        builder.buildRam();
        builder.buildAlmacenamiento();
    }
}
