package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * MotivoViajeControl - Tercer eslabón de la cadena
 * Verifica que el motivo del viaje sea válido
 */
public class MotivoViajeControl extends ControlMigratoriHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isMotivoValido()) {
            System.out.println("[MotivoViajeControl] RECHAZADO: Motivo de viaje no aceptado.");
            return;
        }
        System.out.println("[MotivoViajeControl] Aprobado: Motivo de viaje válido.");
        pasarAlSiguiente(request);
    }
}
