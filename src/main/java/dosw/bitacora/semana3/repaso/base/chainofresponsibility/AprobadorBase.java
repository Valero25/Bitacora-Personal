package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

/**
 * Handler abstracto: guarda la referencia al siguiente y ofrece
 * el método helper para pasar la solicitud sin exponer el campo.
 */
public abstract class AprobadorBase implements Aprobador {
    private Aprobador siguiente;

    @Override
    public void setSiguiente(Aprobador siguiente) { this.siguiente = siguiente; }

    protected void pasarAlSiguiente(int monto) {
        if (siguiente != null) siguiente.aprobar(monto);
        else System.out.println("Monto $" + monto + " sin aprobador disponible.");
    }
}
