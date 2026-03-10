package dosw.bitacora.semana3.repaso.base.factorymethod;

public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[SMS] " + mensaje);
    }
}
