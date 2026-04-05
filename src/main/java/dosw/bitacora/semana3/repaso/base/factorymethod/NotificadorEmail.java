package dosw.bitacora.semana3.repaso.base.factorymethod;

public class NotificadorEmail extends Notificador {
    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}
