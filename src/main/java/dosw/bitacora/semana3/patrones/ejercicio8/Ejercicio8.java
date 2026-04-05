package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * Ejercicio8 - Patrón Chain of Responsibility
 * Simulador de controles migratorios para ingresar a Estados Unidos.
 * Cada control puede aprobar y pasar al siguiente, o rechazar y detener el proceso.
 * La persona no conoce qué control la rechaza ni cuántos controles existen.
 */
public class Ejercicio8 {

    public static void main(String[] args) {

        ControlMigratorio pasaporte  = new PasaporteControl();
        ControlMigratorio antecedentes = new AntecedentesControl();
        ControlMigratorio motivo     = new MotivoViajeControl();
        ControlMigratorio aprobacion = new AprobacionFinalControl();

        pasaporte.setSiguiente(antecedentes);
        antecedentes.setSiguiente(motivo);
        motivo.setSiguiente(aprobacion);

        System.out.println("=== Persona 1: pasaporte válido, antecedentes limpios, motivo inválido ===");
        IngresoRequest persona1 = new IngresoRequest(true, true, false);
        pasaporte.procesar(persona1);
        System.out.println("Resultado: " + (persona1.isAprobado() ? "APROBADO" : "RECHAZADO"));

        System.out.println();

        System.out.println("=== Persona 2: todos los controles aprobados ===");
        IngresoRequest persona2 = new IngresoRequest(true, true, true);
        pasaporte.procesar(persona2);
        System.out.println("Resultado: " + (persona2.isAprobado() ? "APROBADO" : "RECHAZADO"));

        System.out.println();

        System.out.println("=== Persona 3: pasaporte inválido ===");
        IngresoRequest persona3 = new IngresoRequest(false, true, true);
        pasaporte.procesar(persona3);
        System.out.println("Resultado: " + (persona3.isAprobado() ? "APROBADO" : "RECHAZADO"));
    }
}
