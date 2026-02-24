package dosw.bitacora.semana3.repaso.base.factorymethod;

public class NotificadorSMS extends Notificador {
    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionSMS();
    }
}
