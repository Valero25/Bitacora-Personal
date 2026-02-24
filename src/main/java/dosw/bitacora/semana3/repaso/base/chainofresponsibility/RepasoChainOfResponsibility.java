package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

/**
 * ============================================================
 * PATRÓN: Chain of Responsibility  (Comportamiento)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Tienes una solicitud que puede ser manejada por uno de varios
 *   objetos, pero no sabes cuál hasta el momento de ejecución.
 *   Evita acoplar el emisor de una solicitud a su receptor concreto.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Aprobador (interfaz handler) define setSiguiente() y aprobar().
 *   2. AprobadorBase (handler abstracto) guarda la referencia al siguiente
 *      eslabon y ofrece pasarAlSiguiente() como helper protegido.
 *   3. Supervisor, Gerente, Director (handlers concretos) cada uno revisa
 *      si puede manejar el monto; si no, llama pasarAlSiguiente().
 *   4. En main se ENCADENAN los handlers: supervisor → gerente → director.
 *      La solicitud viaja por la cadena hasta que alguien la acepte.
 *
 * REGLA CLAVE:
 *   Cada handler decide: ¿proceso esta solicitud? → sí: la manejo.
 *                                                 → no: la paso al siguiente.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Un ticket de soporte técnico: el agente de nivel 1 resuelve problemas
 *   simples; si no puede, escala al nivel 2; y así hasta el experto.
 *
 * DIAGRAMA MENTAL:
 *   Solicitud → Supervisor → Gerente → Director → (sin más eslabones)
 *   Cada eslabón: if (puedo manejarlo) → handle(); else → pasarAlSiguiente()
 * ============================================================
 */
public class RepasoChainOfResponsibility {
    public static void main(String[] args) {
        Aprobador supervisor = new Supervisor();
        Aprobador gerente    = new Gerente();
        Aprobador director   = new Director();

        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(director);

        supervisor.aprobar(200);
        supervisor.aprobar(1500);
        supervisor.aprobar(10000);
    }
}
