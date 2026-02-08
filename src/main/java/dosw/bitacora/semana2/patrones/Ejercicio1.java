package dosw.bitacora.semana2.patrones;

/**
 * Ejercicio 1: Patrón Creacional (Factory Method)
 * Sistema de notificaciones con Factory Method.
 */

// Interfaz para notificaciones
interface Notification {
    void send(String message);
}

// Notificación por correo electrónico
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando email: " + message);
    }
}

// Notificación por SMS
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

// Notificación push
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificación push: " + message);
    }
}

// Factory para crear notificaciones
class NotificationFactory {
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
