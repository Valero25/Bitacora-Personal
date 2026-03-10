package dosw.bitacora.semana3.repaso.base.factorymethod;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Email] " + mensaje);
    }
}
