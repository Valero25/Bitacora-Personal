package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * PasaporteControl - Primer eslabón de la cadena
 * Verifica que el pasaporte y visa sean válidos
 */
public class PasaporteControl extends ControlMigratoriHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isPasaporteValido()) {
            System.out.println("[PasaporteControl] RECHAZADO: Pasaporte o visa inválidos.");
            return;
        }
        System.out.println("[PasaporteControl] Aprobado: Pasaporte y visa válidos.");
        pasarAlSiguiente(request);
    }
}
