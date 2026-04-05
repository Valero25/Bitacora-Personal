package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Strategy Pattern: Implementación concreta para Email
 * Define cómo se envía una notificación por correo electrónico
 */
public class EmailNotification implements Notification {
    
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending Email to: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Email sent successfully!");
    }
}
