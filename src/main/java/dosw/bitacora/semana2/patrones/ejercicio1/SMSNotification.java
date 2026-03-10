package dosw.bitacora.semana2.patrones.ejercicio1;

/**
 * Notificación por SMS
 */
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}