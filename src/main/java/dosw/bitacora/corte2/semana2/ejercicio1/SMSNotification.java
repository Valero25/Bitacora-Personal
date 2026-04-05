package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Strategy Pattern: Implementación concreta para SMS
 * Define cómo se envía una notificación por SMS
 */
public class SMSNotification implements Notification {
    
    @Override
    public void send(String recipient, String message) {
        // Limitar mensaje a 160 caracteres para SMS
        String smsMessage = message.length() > 160 
            ? message.substring(0, 160) 
            : message;
        
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("Message: " + smsMessage);
        System.out.println("SMS sent successfully!");
    }
}
