package dosw.bitacora.semana2.patrones.ejercicio1;

/**
 * Notificación push
 */
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificación push: " + message);
    }
}