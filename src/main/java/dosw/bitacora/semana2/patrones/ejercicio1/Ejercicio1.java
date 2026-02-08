package dosw.bitacora.semana2.patrones.ejercicio1;

/**
 * Clase principal para el Ejercicio 1: Patrón Creacional (Factory Method)
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        // Crear notificaciones usando el factory
        Notification email = NotificationFactory.createNotification("email");
        Notification sms = NotificationFactory.createNotification("sms");
        Notification push = NotificationFactory.createNotification("push");

        // Enviar mensajes
        email.send("Hola por email");
        sms.send("Hola por SMS");
        push.send("Hola por push");
    }
}