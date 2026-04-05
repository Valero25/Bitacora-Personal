package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Singleton Pattern: Garantiza una única instancia del servicio de envío de notificaciones
 * Strategy Pattern: Utiliza una estrategia dinamicamente seleccionada para enviar
 * 
 * Este es el punto central de gestión de envíos de notificaciones
 */
public class NotificationSender {
    
    private static NotificationSender instance;
    private Notification currentStrategy;
    
    // Constructor privado para evitar instanciación directa
    private NotificationSender() {
        // Estrategia por defecto: Email
        this.currentStrategy = new EmailNotification();
    }
    
    /**
     * Obtiene la única instancia de NotificationSender (Singleton)
     */
    public static synchronized NotificationSender getInstance() {
        if (instance == null) {
            instance = new NotificationSender();
        }
        return instance;
    }
    
    /**
     * Define la estrategia de notificación a usar
     */
    public void setNotificationStrategy(String type) {
        this.currentStrategy = NotificationFactory.createNotification(type);
    }
    
    /**
     * Define la estrategia directamente con una instancia
     */
    public void setNotificationStrategy(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification strategy cannot be null");
        }
        this.currentStrategy = notification;
    }
    
    /**
     * Envía una notificación usando la estrategia actual
     */
    public void send(String recipient, String message) {
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be null or empty");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        
        currentStrategy.send(recipient, message);
    }
    
    /**
     * Obtiene la estrategia actual
     */
    public Notification getCurrentStrategy() {
        return currentStrategy;
    }
}
