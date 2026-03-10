package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * AprobacionFinalControl - Último eslabón de la cadena
 * Emite la aprobación final de ingreso al país
 */
public class AprobacionFinalControl extends ControlMigratoriHandler {

    @Override
    public void procesar(IngresoRequest request) {
        request.setAprobado(true);
        System.out.println("[AprobacionFinalControl] INGRESO APROBADO: Bienvenido a Estados Unidos.");
    }
}
