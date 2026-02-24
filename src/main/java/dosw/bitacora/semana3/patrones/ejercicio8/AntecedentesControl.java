package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * AntecedentesControl - Segundo eslabón de la cadena
 * Verifica que la persona no tenga antecedentes penales
 */
public class AntecedentesControl extends ControlMigratoriHandler {

    @Override
    public void procesar(IngresoRequest request) {
        if (!request.isAntecedentesLimpios()) {
            System.out.println("[AntecedentesControl] RECHAZADO: Antecedentes penales detectados.");
            return;
        }
        System.out.println("[AntecedentesControl] Aprobado: Sin antecedentes penales.");
        pasarAlSiguiente(request);
    }
}
