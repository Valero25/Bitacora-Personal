package dosw.bitacora.semana2.patrones.ejercicio1;

/**
 * Notificación por correo electrónico
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando email: " + message);
    }
}