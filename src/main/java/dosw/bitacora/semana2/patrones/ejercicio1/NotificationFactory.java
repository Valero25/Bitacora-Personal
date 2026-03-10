package dosw.bitacora.semana2.patrones.ejercicio1;

/**
 * Factory para crear notificaciones
 */
public class NotificationFactory {
    public static Notification createNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificación desconocido: " + type);
        }
    }
}