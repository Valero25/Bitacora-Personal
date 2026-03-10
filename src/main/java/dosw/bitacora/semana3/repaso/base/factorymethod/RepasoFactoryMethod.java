package dosw.bitacora.semana3.repaso.base.factorymethod;

/**
 * ============================================================
 * PATRÓN: Factory Method  (Creacional)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   El código cliente necesita crear objetos, pero NO debe depender
 *   de sus clases concretas. Queremos que las subclases decidan qué
 *   objeto instanciar sin cambiar el código que los usa.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Notificador (creator abstracto) tiene el factory method
 *      crearNotificacion() — él define el flujo, pero NO sabe qué
 *      objeto concreto devuelve.
 *   2. NotificadorEmail y NotificadorSMS (concrete creators) sobreescriben
 *      crearNotificacion() y deciden QUÉ producto concreto fabricar.
 *   3. El cliente (main) trabaja con Notificador; nunca con Email/SMS directo.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Una empresa de logística tiene un método "enviar()". Si operan con
 *   camiones o barcos es decisión de las subclases CamionLogistica y
 *   BarcologIstics; el cliente solo llama a enviar().
 *
 * DIAGRAMA MENTAL:
 *   Notificador (abstract) ──── crearNotificacion() [Factory Method]
 *       ├── NotificadorEmail  →  crea NotificacionEmail
 *       └── NotificadorSMS   →  crea NotificacionSMS
 * ============================================================
 */
public class RepasoFactoryMethod {
    public static void main(String[] args) {
        Notificador n1 = new NotificadorEmail();
        Notificador n2 = new NotificadorSMS();

        n1.notificar("Bienvenido!");
        n2.notificar("Tu codigo es 1234");
    }
}
