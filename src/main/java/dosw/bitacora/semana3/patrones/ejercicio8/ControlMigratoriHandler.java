package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * ControlMigratoriHandler - Handler abstracto del patrón Chain of Responsibility
 * Gestiona el enlace al siguiente control y delega si el actual aprueba
 */
public abstract class ControlMigratoriHandler implements ControlMigratorio {

    private ControlMigratorio siguiente;

    @Override
    public void setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
    }

    protected void pasarAlSiguiente(IngresoRequest request) {
        if (siguiente != null) {
            siguiente.procesar(request);
        }
    }
}
