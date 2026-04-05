package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Factory Pattern: Responsable de crear instancias de diferentes tipos de notificaciones
 * Centraliza la creación de objetos Notification
 * Permite agregar nuevos tipos sin modificar código existente
 */
public class NotificationFactory {
    
    /**
     * Crea una instancia de Notification según el tipo especificado
     * 
     * @param type Tipo de notificación: "EMAIL", "SMS", "PUSH"
     * @return Instancia de Notification
     * @throws IllegalArgumentException si el tipo no es reconocido
     */
    public static Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null or empty");
        }
        
        String notificationType = type.toUpperCase();
        
        switch (notificationType) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
