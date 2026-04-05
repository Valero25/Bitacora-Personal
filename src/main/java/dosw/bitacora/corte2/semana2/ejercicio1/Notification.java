package dosw.bitacora.corte2.semana2.ejercicio1;

/**
 * Strategy Pattern: Interfaz que define la estrategia para enviar notificaciones
 * cada canal implementará su propia estrategia de envío
 */
public interface Notification {
    void send(String recipient, String message);
}
