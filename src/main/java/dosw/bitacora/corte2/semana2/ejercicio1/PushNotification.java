package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Strategy Pattern: Implementación concreta para Push Notification
 * Define cómo se envía una notificación push a aplicación móvil
 */
public class PushNotification implements Notification {
    
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Push Notification to device: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Push notification delivered to app!");
    }
}
