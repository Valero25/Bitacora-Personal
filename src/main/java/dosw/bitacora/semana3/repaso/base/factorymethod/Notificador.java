package dosw.bitacora.semana3.repaso.base.factorymethod;

/**
 * Creator abstracto: define el factory method y el flujo de uso.
 * Las subclases deciden QUÉ producto concreto crear.
 */
public abstract class Notificador {
    protected abstract Notificacion crearNotificacion();   // <-- factory method

    public void notificar(String mensaje) {
        Notificacion n = crearNotificacion();
        n.enviar(mensaje);
    }
}
